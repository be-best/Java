package com.Brooke01;
/*
 * 抽象类案例2
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
		System.out.println("写代码");
		
	}
	
}

class Manager extends Employee {
	double bouns;
	@Override
	public void work() {
		System.out.println("盯着程序员写代码");
		
	}
	
}