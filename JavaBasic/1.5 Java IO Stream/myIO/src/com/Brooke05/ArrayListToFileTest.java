package com.Brooke05;
/*
 * ��ArrayLit�����е��ַ����ݴ洢���ı���
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToFileTest {
	public static void main(String[] args) throws IOException {
		//�������϶���
		ArrayList<String> array = new ArrayList<String>();
		
		//�����������Ԫ��
		array.add("hello");
		array.add("world");
		array.add("java");
		
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("ArrayListToFileTest.txt"));
		
		for(int i=0;i<array.size();i++) {
			String line = array.get(i);
			bw.write(line);
			bw.newLine();
			bw.flush();
		}
		
		//�ͷ���Դ
		bw.close();
	}
}
