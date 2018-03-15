package com.Brooke01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * ѧ����Ϣ����ϵͳ
 */

public class StudentManager {
	public static void main(String[] args) throws IOException {
		//��������
		//ArrayList<Student> array = new ArrayList<Student>();
		String studentFile = "StudentFile.txt";
		while(true){
			System.out.println("------��ӭʹ��ѧ������ϵͳ------");
			System.out.println("1 �鿴ѧ����Ϣ");
			System.out.println("2 ���ѧ����Ϣ");
			System.out.println("3 ɾ��ѧ����Ϣ");
			System.out.println("4 �޸�ѧ����Ϣ");
			System.out.println("5 �˳�ϵͳ");
			System.out.println("���������ѡ��");
			
			//����ѡ���
			Scanner sc = new Scanner(System.in);
			String choiceStr = sc.nextLine();
			
			switch(choiceStr) {
			case "1":
				//�鿴ѧ����Ϣ
				findStudent(studentFile);
				break;
				
			case "2":
				//���ѧ����Ϣ
				addStudent(studentFile);
				break;
				
			case "3":
				//ɾ��ѧ����Ϣ
				delectStudent(studentFile);
				break;
				
			case "4":
				//�޸�ѧ����Ϣ
				updateStudent(studentFile);
				break;
				
			default:
				//�˳�
				System.out.println("лл����ʹ�ã�");
				System.exit(0);
				break;
			}
		}
		
	}
	
	//���ļ��ж�ȡ���ݵ�������
	public static void readData(String studentFile,ArrayList<Student> array) throws IOException {
		//�������뻺��������
		BufferedReader br = new BufferedReader(new FileReader(studentFile));
		
		String line;
		while((line = br.readLine()) != null) {
			//�ָ��ַ���
			String[] strArray = line.split(",");
			Student stu = new Student();
			stu.setId(strArray[0]);
			stu.setName(strArray[1]);
			stu.setAge(strArray[2]);
			stu.setAddress(strArray[3]);
			
			//��ӵ�������
			array.add(stu);
		}
		//�ͷ���Դ
		br.close();
		
	}
	
	//�Ѽ����е����ݴ洢���ļ���
	public static void writeData(String studentFile,ArrayList<Student> array) throws IOException {
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter(studentFile));
		
		for(int x=0;x<array.size();x++) {
			//��ʽ���
			Student stu = array.get(x);
			StringBuilder sb = new StringBuilder();
			sb.append(stu.getId()).append(",").append(stu.getName()).append(",").append(stu.getAge()).append(",").append(stu.getAddress());
			//��sbת��Ϊ�ַ������Ͳ�д���ļ�
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}
		
		//�ͷ���Դ
		bw.close();
	}
	
	//�鿴ѧ����Ϣ
	public static void findStudent(String studentFile) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݴ浽������
		readData(studentFile,array);
		if(array.size() == 0){
			System.out.println("�Բ�������ѧ����Ϣ��");
		}
		else{
			System.out.println("ѧ��\t����\t����\t��ַ");
			for(int x=0;x<array.size();x++) {
				//����ѧ�����󣬻�ȡѧ����Ϣ
				Student stu = array.get(x);
				System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getAge()+"\t"+stu.getAddress());
				
			}
		}
	}
	
	//���ѧ����Ϣ
	public static void addStudent(String studentFile) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݴ浽������
		readData(studentFile,array);
		
		Scanner sc = new Scanner(System.in);
		String id;
		while(true) {
			System.out.println("������ѧ��ѧ�ţ�");
			id = sc.nextLine();
			boolean flag = true;
			for(int x=0;x<array.size();x++) {
				Student stu = array.get(x);
				if(id.equals(stu.getId())) {
					flag = false;
					System.out.println("�������ѧ���Ѿ���ռ�ã����������룡");
				}
				
			}
			if(flag == true) {
				break;
			}
		}
		
		System.out.println("������ѧ��������");
		String name = sc.nextLine();
		System.out.println("������ѧ�����䣺");
		String age = sc.nextLine();
		System.out.println("������ѧ����ס�أ�");
		String address = sc.nextLine();
		
		//����ѧ��������set������ȡѧ����Ϣ
		Student stu = new Student();
		stu.setId(id);
		stu.setName(name);
		stu.setAge(age);
		stu.setAddress(address);
		
		//��ѧ��������뼯����
		array.add(stu);
		
		//�Ѽ����е�����д���ļ���
		writeData(studentFile, array);
		
		System.out.println("��ӳɹ���");
	}
	
	//ɾ��ѧ����Ϣ
	public static void delectStudent(String studentFile) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݴ浽������
		readData(studentFile,array);
		
		System.out.println("��������Ҫɾ����ѧ��ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int flag = -1;
		for(int x=0;x<array.size();x++) {
			//����һ��ѧ������
			Student stu = array.get(x);
			if(id.equals(stu.getId())) {
				array.remove(x);
				flag = x;
			}
		}
		if(flag == -1){
			System.out.println("�Բ����������ѧ�Ų����ڣ�");
		}
		else {
			//�Ѽ����е�����д���ļ���
			writeData(studentFile, array);
			
			System.out.println("ɾ���ɹ���");
		}
		
	}
	
	//�޸�ѧ����Ϣ
	public static void updateStudent(String studentFile) throws IOException {
		//�������϶���
		ArrayList<Student> array = new ArrayList<Student>();
		//���ļ��а����ݴ浽������
		readData(studentFile,array);
		
		System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ�ţ�");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		int flag = -1;
		for(int x=0;x<array.size();x++) {
			Student stu = array.get(x);
			if(id.equals(stu.getId())) {
				flag = x;
				System.out.println("�������µ�ѧ��ѧ�ţ�");
				String newId = sc.nextLine();
				System.out.println("�������µ�ѧ��������");
				String newName = sc.nextLine();
				System.out.println("�������µ�ѧ�����䣺");
				String newAge = sc.nextLine();
				System.out.println("�������µ�ѧ����ס�أ�");
				String newAddress = sc.nextLine();
				//����ѧ����Ϣ
				stu.setId(newId);
				stu.setName(newName);
				stu.setAge(newAge);
				stu.setAddress(newAddress);
				//���º�����ݴ��뼯��֮��
				array.set(x,stu);
			}
			
		}
		if(flag == -1) {
			System.out.println("�Բ����������ѧ��ѧ�Ų����ڣ�");
		}
		else {
			//�Ѽ����е�����д���ļ���
			writeData(studentFile, array);
			
			System.out.println("�޸ĳɹ���");
		}
	}
}
