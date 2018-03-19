package com.Brooke01;
/*
 * 构造的执行顺序
 */
public class ExtendsDemo5 {
	public static void main(String[] args) {
		Son1 s = new Son1();
	} 
}

class Dad1 {
	public Dad1() {
		System.out.println("我是父类无参构造");
	}
	
	public Dad1(int num) {
		System.out.println("我是父类有参构造");
	}
}

class Son1 extends Dad1{
	public Son1() {
		this(1);//调用子类的有参构造，那么父类的无参构造不在这调用，而是在子类的有参构造中调用。
		System.out.println("我是子类无参构造");
	}
	public Son1(int num) {
		System.out.println("我是子类有参构造");
	}
	
}