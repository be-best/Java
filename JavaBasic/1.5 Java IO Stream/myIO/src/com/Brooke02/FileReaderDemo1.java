package com.Brooke02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo1 {
	public static void main(String[] args) throws IOException {
		//��������������
		FileReader fr = new FileReader("FileReaderDemo1.txt");
	
		//int read();һ�ζ�ȡһ���ַ�
		int ch;
		while((ch=fr.read()) != -1) {
			System.out.print((char)ch);
		}
		
//		char[] chs = {'a','b','c','d','e'};
//		int ch = fr.read(chs);
//		System.out.println(ch);
		//�ͷ���Դ
		fr.close();
	}
}
