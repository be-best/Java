package com.Brooke04;

public class InnerDemo5 {
	public static void main(String[] args) {
		methodEat(new Cat());
	}
	
	public static void methodEat(Animal a) {
		a.eat();
	}
}
