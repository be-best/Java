package com.Brooke01;

public class ExtendsDemo6 {
	public static void main(String[] args) {
		Ball b = new Ball();
		
		Soccer s = new Soccer();
		s.method();
	}
}

class Ball {
	String name = "ball";
	
}

class Soccer extends Ball{
	public void method() {
		System.out.println(this.name);
	}
}