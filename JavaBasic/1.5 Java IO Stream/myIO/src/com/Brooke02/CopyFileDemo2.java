package com.Brooke02;
/*
 * IO流复制文本文件
 * 一次读写一个字符数组
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo2 {
	public static void main(String[] args) throws IOException {
		//创建输入流对象
		FileReader fr = new FileReader("FileWriterDemo1.java");
		
		//创建输出流对象
		FileWriter fw = new FileWriter("CopyWriter.txt");
		
		char[] chs = new char[1024];
		int len;
		while((len = fr.read(chs)) != -1) {
			fw.write(chs, 0, len);
		}
		
		//释放资源
		fr.close();
		fw.close();
	}
}
