package com.Brooke01;
/*
 * 成员内部类：
 * 		位置和成员变量、成员方法所在的位置一样，位于类中方法外
 * 		内部类可以直接访问外部类成员，包括私有成员
 */
public class InnerDemo1 {
	public static void main(String[] args) {
		//创建Outer对象
		Outer out = new Outer();
		out.method();
		//创建Inner对象
		Outer.Inner in = new Outer().new Inner();
		in.fuction();
		//创建static修饰的Inner1对象,直接new内部类的对象,不用创建外部类对象
		Outer.Inner1 in1 = new Outer.Inner1();
		in1.fuction();
		//直接用内部类类名调用方法，这时内部类和方法都要用static修饰
		Outer.Inner2.fuction();
	}
}

//外部类
class Outer {
	private int num;
	public void method() {
		Inner i = new Inner();
		i.fuction();
	}
	
	//成员内部类
	class Inner {
		public void fuction() {
			System.out.println("Inner内部类");
		}
	}
	
	static class Inner1 {
		public void fuction() {
			System.out.println("Inner1内部类");
		}
		
	}
	
	static class Inner2 {
		public static void fuction() {
			System.out.println("Inner2内部类");
		}
		
	}
}
