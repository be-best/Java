package com.zws02;

import java.util.Scanner;

public class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("���������䣺");
			int age = sc.nextInt();
			Student stu = new Student();
			stu.name = "�Ŵ�׳";
			stu.setAge(age);
			stu.show();
			System.out.println("-----------");
		}
		
	}
}
