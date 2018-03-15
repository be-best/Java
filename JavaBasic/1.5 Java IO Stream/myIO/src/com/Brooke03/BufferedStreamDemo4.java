package com.Brooke03;
/*
 * �����ַ����������⹦�ܸ����ı�
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedStreamDemo4 {
	public static void main(String[] args) throws IOException {
		//�½����뻺��������
		BufferedReader br = new BufferedReader(new FileReader("FileWriterDemo1.java"));
		
		//�½��������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("BufferedDemo4.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			bw.write(line);
			bw.newLine(); //����
			bw.flush();
		}
		
		//�ͷ���Դ
		br.close();
		bw.close();
	}
}
