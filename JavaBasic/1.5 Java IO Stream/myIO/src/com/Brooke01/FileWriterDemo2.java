package com.Brooke01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("FileWriterDemo2.txt");
		
		//void write(String str);
		//写一个字符串数据
		fw.write("abc|");
		
		//void write(int ch);
		//写一个字符数据
		fw.write(97);
        
		//void write(char[] chs)
		//写一个数组数据
		char[] chs = {'|','a','b','c','d','|'};
		fw.write(chs);
		
		//void write(char[],int index,int len);
		//从index索引开始写len个数据
		fw.write(chs,3,3);
		
		
		//void write(String str,int index,int len);
		//从index索引开始写len个数据
		fw.write("abcde",2,3);
		fw.flush();
		
		fw.close();
	}
}
