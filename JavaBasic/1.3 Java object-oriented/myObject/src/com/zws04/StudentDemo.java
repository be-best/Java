package com.zws04;

public class StudentDemo {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.show();
		Student stu1 = new Student(28);
		stu1.show();
		Student stu2 = new Student("�Ŵ�׳");
		stu2.show();
		Student stu3 = new Student("�Ŵ�׳",28);
		stu3.show();		
	}
}
