package com.Brooke02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * int read(char[] buf)
 * һ�ζ�ȡһ���ַ���������ݣ����ص���ʵ�ʶ�ȡ���ַ�����.len = fr.read(char[] buf)
 */
public class FileReaderDemo2 {
	public static void main(String[] args) throws IOException {
		//��������������
		FileReader fr = new FileReader("FileWriterDemo1.java");
		
		char[] chs= new char[1024];
		int len; //���ص���ʵ�ʶ�ȡ���ַ�����
		while((len = fr.read(chs)) != -1) {
			System.out.print(new String(chs,0,len));
		}
		
	}
}
