package com.Brooke01;

public class myObjectDemo1 {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "����";
		stu.age = 10;
		System.out.println(stu.toString());
	}
}

class Student {
	String name;
	int age;
	
	//��дtoString����
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}