package com.Brooke03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 运用输入输出缓冲流复制文本
 */
public class BufferedStreamDemo2 {
	public static void main(String[] args) throws IOException {
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedDemo2.txt"));
		
		//创建输入缓冲流对象
		BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		BufferedReader br1 = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		
		//一次读写一个字符
		int cha;
		while((cha = br.read()) != -1) {
			bw.write(cha);
		}
		
		//一次读写一个字符数组
		char[] chs = new char[1024];
		int len;
		while((len = br1.read(chs)) != -1) {
			bw.write(chs, 0, len);
		}
		
		//释放资源
		bw.close();
		br.close();
		br1.close();
	}
}
