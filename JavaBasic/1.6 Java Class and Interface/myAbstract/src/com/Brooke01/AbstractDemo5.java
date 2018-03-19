package com.Brooke01;
/*
 * �����స��
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
	System.out.println("����");
		
	}
	
}

class Woman extends Person {

	@Override
	public void show() {
		System.out.println("Ů��");
		
	}
	
}