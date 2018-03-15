package com.Brooke02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo1 {
	public static void main(String[] args) throws IOException {
		//创建输入流对象
		FileReader fr = new FileReader("FileReaderDemo1.txt");
	
		//int read();一次读取一个字符
		int ch;
		while((ch=fr.read()) != -1) {
			System.out.print((char)ch);
		}
		
//		char[] chs = {'a','b','c','d','e'};
//		int ch = fr.read(chs);
//		System.out.println(ch);
		//释放资源
		fr.close();
	}
}
