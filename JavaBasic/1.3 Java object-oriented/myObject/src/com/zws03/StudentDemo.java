package com.zws03;

import java.util.Scanner;

import com.zws03.Student;

public class StudentDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("请输入年龄：");
			int age = sc.nextInt();
			Student stu = new Student();
			stu.setAge(age);
			stu.setName("张大壮");
			stu.show();
			System.out.println("-----------");
			
		}
	}
}
