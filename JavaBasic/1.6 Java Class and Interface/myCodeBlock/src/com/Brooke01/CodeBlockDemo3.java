package com.Brooke01;
/*
 * 静态代码块
 */
public class CodeBlockDemo3 {
	public static void main(String[] args) {
		String name = "苍老师";
		int age = 30;
		Teacher1 ter1 = new Teacher1();
		Teacher1 ter2 = new Teacher1(name,age);
	}
}

class Teacher1 {
	String name;
	int age;
	
	//静态代码块:随着类的加载而加载，只加载一次，加载类时需要做的一些初始化，比如加载驱动
	static{
		//提取构造方法中的共性：输出"我爱Java"
		System.out.println("我爱Java！");
	}
	
	//无参构造
	public Teacher1() {
		//System.out.println("我爱Java！");
		System.out.println("我是无参构造");
	}
	
	//有参构造
	public Teacher1(String name,int age) {
		this.name = name;
		this.age = age;
		//System.out.println("我爱Java！");
		System.out.println("我是有参构造");
	}
}