package com.Brooke01;

public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder strBui = new StringBuilder();
		//链式编程，拼接
		strBui.append(true).append("abc").append(100);
		System.out.println(strBui);
		//反转
		System.out.println(strBui.reverse());
	}
}
