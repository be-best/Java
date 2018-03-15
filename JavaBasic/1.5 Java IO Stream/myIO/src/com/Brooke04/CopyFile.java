package com.Brooke04;
/*
 * 5�ַ���ʵ���ı�����
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
	
	//������һ�ζ�дһ���ַ�
	public static void method1(String srcFileName,String destFileName) throws IOException {
		//�������������
		FileWriter fw = new FileWriter("srcFileName"); 
		//��������������
		FileReader fr = new FileReader("destFileName");
		
		int chs;
		while((chs = fr.read()) != -1) {
			fw.write(chs);
			fw.flush();
		}
		fw.close();
		fr.close();
	}
	
	//������һ�ζ�дһ���ַ�����
	public static void method2(String srcFileName,String destFileName) throws IOException {
		//�������������
		FileWriter fw = new FileWriter("srcFileName"); 
		//��������������
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
	
	//������һ�ζ�дһ���ַ� 
	public static void method3(String srcFileName,String destFileName) throws IOException {
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter(srcFileName));
		//�������뻺��������
		BufferedReader br = new BufferedReader(new FileReader(destFileName));
		
		int chs;
		while((chs = br.read()) != -1) {
			bw.write(chs);
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	//������һ�ζ�дһ���ַ����� 
	public static void method4(String srcFileName,String destFileName) throws IOException {
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter(srcFileName));
		//�������뻺��������
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
		
	//�ص㣺���������⹦�ܸ����ı�.
	public static void method5(String srcFileName,String destFileName) throws IOException {
		    //�����������������
			BufferedWriter bw = new BufferedWriter(new FileWriter(srcFileName));
			//�������뻺��������
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