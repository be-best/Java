package com.Brooke01;
/*
 * �����స��2
 */
public class AbstractDemo4 {
	public static void main(String[] args) {
		Programmers p = new Programmers();
		p.work();
		
		Manager m = new Manager();
		m.work();
	}
}

abstract class Employee {
	String name;
	String age;
	double pay;
	
	public abstract void work();
}

class Programmers extends Employee {

	@Override
	public void work() {
		System.out.println("д����");
		
	}
	
}

class Manager extends Employee {
	double bouns;
	@Override
	public void work() {
		System.out.println("���ų���Աд����");
		
	}
	
}