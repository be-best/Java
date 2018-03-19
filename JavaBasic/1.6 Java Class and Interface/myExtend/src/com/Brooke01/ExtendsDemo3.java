package com.Brooke01;
/*
 * 继承中成员变量的特点
 */
public class ExtendsDemo3 {
	public static void main(String[] args) {
		Son s =new Son();
		s.show();
	}
}

class Dad {
	String name = "张一";
}

class Son extends Dad{
	String name = "张二";
	public void show() {
		String name = "张三";
		
		//父类成员变量
		System.out.println(super.name);
		//此类的成员变量
		System.out.println(this.name);
		//此方法中的局部变量
		System.out.println(name);
	}
}