package com.Brooke02;

/*
 * IO�������ı��ļ�
 * һ�ζ�дһ���ַ�
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo {

	public static void main(String[] args) throws IOException {
		//�������������
		FileWriter fw = new FileWriter("copy.java");
		
		//��������������
		FileReader fr = new FileReader("FileWriterDemo1.java");
		
		int ch;
		while((ch = fr.read()) != -1) {
			fw.write(ch);
		}
		
		//�ͷ���Դ
		fr.close();
		fw.close();
	}
}
