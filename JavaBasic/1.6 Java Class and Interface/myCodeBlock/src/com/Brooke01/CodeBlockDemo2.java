package com.Brooke01;
/*
 * 构造代码块
 */
public class CodeBlockDemo2 {
	public static void main(String[] args) {
		String name = "苍老师";
		int age = 30;
		Teacher ter1 = new Teacher();
		Teacher ter2 = new Teacher(name,age);
	}
}

class Teacher {
	String name;
	int age;
	//构造代码块,提取构造方法中的共性，每次创建对象都会执行，并且在构造方法之前执行
	{
		//提取构造方法中的共性：输出"我爱Java"
		System.out.println("我爱Java！");
	}
	
	//无参构造
	public Teacher() {
		//System.out.println("我爱Java！");
		System.out.println("我是无参构造");
	}
	
	//有参构造
	public Teacher(String name,int age) {
		this.name = name;
		this.age = age;
		//System.out.println("我爱Java！");
		System.out.println("我是有参构造");
	}
}