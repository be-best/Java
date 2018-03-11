package com.zws02;

import java.util.Scanner;

public class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("请输入年龄：");
			int age = sc.nextInt();
			Student stu = new Student();
			stu.name = "张大壮";
			stu.setAge(age);
			stu.show();
			System.out.println("-----------");
		}
		
	}
}
