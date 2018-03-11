package com.zws01;

public class StudentDemo {
	public static void main(String[] args) {
		Student stu = new Student();
		
		//调用成员方法
		stu.study();
		stu.eat();
		System.out.println("-----------");
		//给成员变量赋值
		stu.age=18;
		stu.name="张三";
		//输出成员变量
		System.out.println("姓名是："+stu.name);
		System.out.println("年龄是："+stu.age);
	}
}
