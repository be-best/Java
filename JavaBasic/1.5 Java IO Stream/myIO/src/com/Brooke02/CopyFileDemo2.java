package com.Brooke02;
/*
 * IO�������ı��ļ�
 * һ�ζ�дһ���ַ�����
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyFileDemo2 {
	public static void main(String[] args) throws IOException {
		//��������������
		FileReader fr = new FileReader("FileWriterDemo1.java");
		
		//�������������
		FileWriter fw = new FileWriter("CopyWriter.txt");
		
		char[] chs = new char[1024];
		int len;
		while((len = fr.read(chs)) != -1) {
			fw.write(chs, 0, len);
		}
		
		//�ͷ���Դ
		fr.close();
		fw.close();
	}
}
