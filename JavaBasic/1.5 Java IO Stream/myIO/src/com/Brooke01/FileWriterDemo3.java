package com.Brooke01;

import java.io.FileWriter;
import java.io.IOException;

/*
 * ʵ�ֻ��У�
 *		"\r\n"
 *		windows:"\r\n"
 *		linux:"\n"
 *		mac:"\r" 
 * ʵ��׷��д�����ݣ�
 * 		FileWriter(String fileName,boolean append);
 * 
 */
public class FileWriterDemo3 {
	public static void main(String[] args) throws IOException {
		//�������������
		//FileWriter fw = new FileWriter("FileWriterDemo3.txt");
		
		//Ĭ����false,Ϊʵ��׷��д��������true
		//����һ��׷��һ��
		FileWriter fw = new FileWriter("FileWriterDemo3.txt",true);		
		//ʵ�ֻ���
		for(int x=0;x<10;x++) {
			fw.write("helloworld"+x);
			fw.write("\r\n");
		}
		
		fw.close();
		

	}
}
