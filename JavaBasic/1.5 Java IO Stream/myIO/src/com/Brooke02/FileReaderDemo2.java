package com.Brooke02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * int read(char[] buf)
 * 一次读取一个字符数组的数据，返回的是实际读取的字符个数.len = fr.read(char[] buf)
 */
public class FileReaderDemo2 {
	public static void main(String[] args) throws IOException {
		//创建输入流对象
		FileReader fr = new FileReader("FileWriterDemo1.java");
		
		char[] chs= new char[1024];
		int len; //返回的是实际读取的字符个数
		while((len = fr.read(chs)) != -1) {
			System.out.print(new String(chs,0,len));
		}
		
	}
}
