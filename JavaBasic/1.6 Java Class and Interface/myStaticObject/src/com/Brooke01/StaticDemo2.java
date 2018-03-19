package com.Brooke01;
/*
 * 静态成员方法只能调用静态(成员方法/成员变量)
 * 非静态成员方法既能调用静态也能调用非静态(成员方法/成员变量)
 */
public class StaticDemo2 {
	public static void main(String[] args) {
		Student.graduateFrom = "拉玛西亚"; 
		Student stu = new Student();
		stu.study();
	}
}

class Student {
	String name;
	int age;
	static String graduateFrom;
	
	//静态成员方法:study
	public static void study() {
		//静态成员方法可以调用静态成员变量:调用graduateFrom
		System.out.println(graduateFrom);
		//静态成员方法可以调用静态成员方法：调用sleep
		sleep();
		
		//静态成员方法不能调用非静态成员变量：这边不能调用age
		//System.out.println(age);
		//静态成员方法不能调用非静态成员方法：这边不能调用eat方法
		//eat();
	}
	
	//静态成员方法：sleep
	public static void sleep() {
		System.out.println("睡觉！");
	}
	
	//非静态成员方法：eat
	public void eat() {
		System.out.println("吃");
		//非静态成员方法可以调用静态成员变量:调用graduateFrom
		System.out.println(graduateFrom);
		//非静态成员方法可以调用静态成员方法：调用sleep
		sleep();
		
		//另外，非静态成员方法可以调用非静态成员方法和变量
		
	}
}