package com.zws05;

public class Student {
	//��Ա����
	private int age;
	private String name;
	
	//���췽��
	public Student(){
			
		}
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	
	//��Ա����
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	
}
