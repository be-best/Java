package com.Brooke05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * ����¼��ѧ����Ϣ���뼯�ϣ��������ϰ�ѧ����Ϣ�����ı�(����ָ���)
 */
public class StudentTest {
	public static void main(String[] args) throws IOException {
		//�����Ἧ�϶���
		ArrayList<Student> array = new ArrayList<Student>();
		for(int x=0;x<3;x++) {
			addStudent(array);
		}
		
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("StudentTest.txt"));
		
		for(int x=0;x<array.size();x++) {
//			String id = array.get(x).getId();
//			bw.write(id+",");
//			String name = array.get(x).getName();
//			bw.write(name+",");
//			String age = array.get(x).getAge();
//			bw.write(age+",");
//			String address = array.get(x).getAddress();
//			bw.write(address);
//			bw.newLine();
			
			Student stu = array.get(x);
			//��ʽ���
			StringBuilder sb = new StringBuilder();
			sb.append(stu.getId()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getAddress());
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//�ͷ���Դ
		bw.close();
		
	}
	
	//���ѧ��
	public static void addStudent(ArrayList<Student> array) {
		Scanner sc = new Scanner(System.in);
		String id = "";
		while(true) {
			System.out.println("������ѧ�ţ�");
			id = sc.nextLine();
			boolean flag = true;
			for(int x=0;x<array.size();x++) {
				if(id.equals(array.get(x).getId())) {
					System.out.println("�������ѧ���Ѿ���ռ�ã����������룡");
					flag = false;
				}
			}
			if(flag == true) {
				break;
			}
		}
		System.out.println("������������");
		String name = sc.nextLine();
		System.out.println("���������䣺");
		String age = sc.nextLine();
		System.out.println("�������ס�أ�");
		String address = sc.nextLine();
		
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		stu.setAddress(address);
		
		array.add(stu);
	}
}
