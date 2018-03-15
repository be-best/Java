package com.Brooke05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * ���ı��ļ��е���Ϣ��ȡ�����洢�������У����������ϣ��ڿ���̨���
 */
public class StudentTest1 {
	public static void main(String[] args) throws IOException {
		//�������뻺�������� 
		BufferedReader br = new BufferedReader(new FileReader("StudentTest.txt"));
		
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		
		String line;
		while((line = br.readLine()) != null) {
			//�ָ��ַ���,�ָ���Ԫ�ش洢��������,��","Ϊ�ֽ��
			String[] strArray = line.split(",");
			Student stu = new Student();
			stu.setId(strArray[0]);
			stu.setName(strArray[1]);
			stu.setAge(strArray[2]);
			stu.setAddress(strArray[3]);
			
			array.add(stu);
		}
		
		//�ͷ���Դ
		br.close();
		System.out.println("ѧ��\t����\t����\t��ס��");
		for(int x=0;x<array.size();x++) {
			Student stu = array.get(x);
			System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
		}
	}
}
