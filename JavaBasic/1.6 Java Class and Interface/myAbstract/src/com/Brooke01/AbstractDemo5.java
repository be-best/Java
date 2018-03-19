package com.Brooke01;
/*
 * 抽象类案例
 */
public class AbstractDemo5 {
	public static void main(String[] args) {
		Man m = new Man();
		m.show();
		
		Woman w = new Woman();
		w.show();
	}
}

abstract class Person {
	String gender;
	int age;
	
	public abstract void show();
}

class Man extends Person {

	@Override
	public void show() {
	System.out.println("男性");
		
	}
	
}

class Woman extends Person {

	@Override
	public void show() {
		System.out.println("女性");
		
	}
	
}