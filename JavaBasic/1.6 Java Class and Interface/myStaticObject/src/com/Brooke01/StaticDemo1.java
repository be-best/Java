package com.Brooke01;

public class StaticDemo1 {
	public static void main(String[] args) {
		//����ֱ�ӵ��þ�̬��Ա����
		Person.graduateFrom = "��������";
		
		Person p = new Person();
		p.name = "÷��";
		p.age = 30;
		Person p2 = new Person();
		p2.name = "Ƥ��";
		p2.age = 30;
		p.show();
		p2.show();
	}
}

class Person {
	String name;
	int age;
	//���徲̬��Ա����
	static String graduateFrom;
	
	public void show() {
		System.out.println(name+"---"+age+"---"+graduateFrom);
	}
}
