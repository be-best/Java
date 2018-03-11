package com.zws04;
/*
 * 构造方法的使用：
 */
public class Student {
	private String name;
	private int age;
	
	public Student(){
		
	}
	
	public Student(int age) {
		this.age = age;
	}
	
	public Student(String name) {
		this.name = name;
	}
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	public void show() {
		System.out.println("姓名是："+name+",年龄是："+age);
		System.out.println("-------------------");
	}
}
