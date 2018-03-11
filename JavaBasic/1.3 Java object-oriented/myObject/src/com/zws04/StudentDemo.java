package com.zws04;

public class StudentDemo {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.show();
		Student stu1 = new Student(28);
		stu1.show();
		Student stu2 = new Student("张大壮");
		stu2.show();
		Student stu3 = new Student("张大壮",28);
		stu3.show();		
	}
}
