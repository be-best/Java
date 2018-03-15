package com.Brooke03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ����������������������ı�
 */
public class BufferedStreamDemo2 {
	public static void main(String[] args) throws IOException {
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedDemo2.txt"));
		
		//�������뻺��������
		BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		BufferedReader br1 = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		
		//һ�ζ�дһ���ַ�
		int cha;
		while((cha = br.read()) != -1) {
			bw.write(cha);
		}
		
		//һ�ζ�дһ���ַ�����
		char[] chs = new char[1024];
		int len;
		while((len = br1.read(chs)) != -1) {
			bw.write(chs, 0, len);
		}
		
		//�ͷ���Դ
		bw.close();
		br.close();
		br1.close();
	}
}
