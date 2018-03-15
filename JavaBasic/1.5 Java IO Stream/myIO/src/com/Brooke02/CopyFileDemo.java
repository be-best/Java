package com.Brooke02;

/*
 * IO流复制文本文件
 * 一次读写一个字符
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo {

	public static void main(String[] args) throws IOException {
		//创建输出流对象
		FileWriter fw = new FileWriter("copy.java");
		
		//创建输入流对象
		FileReader fr = new FileReader("FileWriterDemo1.java");
		
		int ch;
		while((ch = fr.read()) != -1) {
			fw.write(ch);
		}
		
		//释放资源
		fr.close();
		fw.close();
	}
}
