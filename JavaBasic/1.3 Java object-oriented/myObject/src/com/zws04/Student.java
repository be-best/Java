package com.zws04;
/*
 * ���췽����ʹ�ã�
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
		System.out.println("�����ǣ�"+name+",�����ǣ�"+age);
		System.out.println("-------------------");
	}
}
