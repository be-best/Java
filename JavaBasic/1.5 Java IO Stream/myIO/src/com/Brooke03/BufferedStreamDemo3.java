package com.Brooke03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * ������������������⹦��
 * BufferedWriter��
 * 		void newLine(); ����
 * BufferedReader:
 * 		String readLine(); ��ȡһ�����ݣ�����ȡ���з�
 */
public class BufferedStreamDemo3 {
	public static void main(String[] args) throws IOException {
		//������������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("BUfferedDemo3.txt"));
		
		//�������뻺��������
		BufferedReader br = new BufferedReader(new FileReader("helloworld.txt"));
		
		//void newLine();
		for(int x=0;x<10;x++) {
			bw.write("helloworld"+x);
			bw.newLine(); //����
			bw.flush();
		}
		
		//String readLine();
		//��ȡһ�����ݣ�����ȡ���з�
		String line;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		
		//�ͷ���Դ
		bw.close();
		br.close();
	}
}
