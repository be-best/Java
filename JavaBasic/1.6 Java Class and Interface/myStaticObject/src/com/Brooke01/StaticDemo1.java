package com.Brooke01;

public class StaticDemo1 {
	public static void main(String[] args) {
		//类名直接调用静态成员变量
		Person.graduateFrom = "拉玛西亚";
		
		Person p = new Person();
		p.name = "梅西";
		p.age = 30;
		Person p2 = new Person();
		p2.name = "皮克";
		p2.age = 30;
		p.show();
		p2.show();
	}
}

class Person {
	String name;
	int age;
	//定义静态成员变量
	static String graduateFrom;
	
	public void show() {
		System.out.println(name+"---"+age+"---"+graduateFrom);
	}
}
