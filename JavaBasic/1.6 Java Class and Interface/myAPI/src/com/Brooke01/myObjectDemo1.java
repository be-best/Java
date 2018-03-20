package com.Brooke01;

public class myObjectDemo1 {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.name = "张三";
		stu.age = 10;
		System.out.println(stu.toString());
	}
}

class Student {
	String name;
	int age;
	
	//重写toString方法
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}