package com.Brooke01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("FileWriterDemo2.txt");
		
		//void write(String str);
		//дһ���ַ�������
		fw.write("abc|");
		
		//void write(int ch);
		//дһ���ַ�����
		fw.write(97);
        
		//void write(char[] chs)
		//дһ����������
		char[] chs = {'|','a','b','c','d','|'};
		fw.write(chs);
		
		//void write(char[],int index,int len);
		//��index������ʼдlen������
		fw.write(chs,3,3);
		
		
		//void write(String str,int index,int len);
		//��index������ʼдlen������
		fw.write("abcde",2,3);
		fw.flush();
		
		fw.close();
	}
}
