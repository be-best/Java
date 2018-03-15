package com.Brooke03;
/*
 * 输入输出缓冲流
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo1 {
	public static void main(String[] args) throws IOException {
		//创建输出缓冲流
		BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedDemo1.txt"));
		
		//创建输入缓冲流
		BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		BufferedReader br1 = new BufferedReader(new FileReader("FileWriterDemo3.java"));
		
		//写数据
		bw.write("helloworld!");
		
		//读数据
		//一次读写一个字符
		int cha;
		while((cha = br.read()) != -1) {
			System.out.print((char)cha);
		}
		
		//一次读写一个字符数组
		char[] chs = new char[1024];
		int len;
		while((len = br1.read(chs)) != -1) {
			System.out.println(new String(chs,0,len));
		}
		
		//释放资源
		bw.close();
		br.close();
		br1.close();
	}
}
