package com.Brooke03;
/*
 * �������������
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo1 {
	public static void main(String[] args) throws IOException {
		//�������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedDemo1.txt"));
		
		//�������뻺����
		BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		BufferedReader br1 = new BufferedReader(new FileReader("FileWriterDemo3.java"));
		
		//д����
		bw.write("helloworld!");
		
		//������
		//һ�ζ�дһ���ַ�
		int cha;
		while((cha = br.read()) != -1) {
			System.out.print((char)cha);
		}
		
		//һ�ζ�дһ���ַ�����
		char[] chs = new char[1024];
		int len;
		while((len = br1.read(chs)) != -1) {
			System.out.println(new String(chs,0,len));
		}
		
		//�ͷ���Դ
		bw.close();
		br.close();
		br1.close();
	}
}
