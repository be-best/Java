package com.zws03;

import java.util.Scanner;

import com.zws03.Student;

public class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("���������䣺");
			int age = sc.nextInt();
			Student stu = new Student();
			stu.setAge(age);
			stu.setName("�Ŵ�׳");
			stu.show();
			System.out.println("-----------");
			
		}
	}
}
