package com.Brooke01;

public class AbstractDemo2 {
	public static void main(String[] args) {
		Soccer s = new Soccer();
		s.show();
	}
}

abstract class Ball {
	String name = "×ãÇò";
}

class Soccer extends Ball {
	public void show() {
		System.out.println(name);
	}
}