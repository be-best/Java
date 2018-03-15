package com.Brooke04;
/*
 * 5种方法实现文本复制
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFile {
	public static void main(String[] args) throws IOException {
		String destFileName = "FileWriterDemo3.java";
		String srcFileName = "CopyFile.txt";
		
		method1(srcFileName,destFileName);
		method2(srcFileName,destFileName);
		method3(srcFileName,destFileName);
		method4(srcFileName,destFileName);
		method5(srcFileName,destFileName);
	}
	
	//基本流一次读写一个字符
	public static void method1(String srcFileName,String destFileName) throws IOException {
		//创建输出流对象
		FileWriter fw = new FileWriter("srcFileName"); 
		//创建输入流对象
		FileReader fr = new FileReader("destFileName");
		
		int chs;
		while((chs = fr.read()) != -1) {
			fw.write(chs);
			fw.flush();
		}
		fw.close();
		fr.close();
	}
	
	//基本流一次读写一个字符数组
	public static void method2(String srcFileName,String destFileName) throws IOException {
		//创建输出流对象
		FileWriter fw = new FileWriter("srcFileName"); 
		//创建输入流对象
		FileReader fr = new FileReader("destFileName");
		
		char[] chs = new char[1024];
		int len;
		while((len = fr.read(chs)) != -1) {
			fw.write(chs, 0, len);
			fw.flush();
		}
		fw.close();
		fr.close();
		}
	
	//缓冲流一次读写一个字符 
	public static void method3(String srcFileName,String destFileName) throws IOException {
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(srcFileName));
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader(destFileName));
		
		int chs;
		while((chs = br.read()) != -1) {
			bw.write(chs);
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	//缓冲流一次读写一个字符数组 
	public static void method4(String srcFileName,String destFileName) throws IOException {
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter(srcFileName));
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader(destFileName));
		
		char[] chs = new char[1024];
		int len;
		while((len = br.read(chs)) != -1) {
			bw.write(chs, 0, len);
			bw.flush();
		}
		bw.close();
		br.close();
	}
		
	//重点：缓冲流特殊功能复制文本.
	public static void method5(String srcFileName,String destFileName) throws IOException {
		    //创建输出缓冲流对象
			BufferedWriter bw = new BufferedWriter(new FileWriter(srcFileName));
			//创建输入缓冲流对象
			BufferedReader br = new BufferedReader(new FileReader(destFileName));
			
			String line;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			br.close();
		}
}