package com.Brooke05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * ��ȡ�ı����ݴ浽�����в���������
 */
public class FileToArrayListTest {
	public static void main(String[] args) throws IOException {
		//�������϶���
		ArrayList<String> array = new ArrayList<String>();
		
		//�������뻺��������
		BufferedReader br = new BufferedReader(new FileReader("ArrayListToFileTest.txt"));
		
		String line;
		while((line = br.readLine()) != null) {
			array.add(line);
		}
		
		//�ͷ���Դ
		br.close();
		
		for(int x=0;x<array.size();x++) {
			System.out.println(array.get(x));
		}
	}

}
