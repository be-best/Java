package com.brooke01;

public class StringDemo3 {
	public static void main(String[] args) {
		String str1 = "hello";
		String str2 = "hello";
		String str3 = "HELLO";
		
		System.out.println(str1.equals(str2));
		System.out.println(str1.equals(str3));
		System.out.println("----------");
		
		System.out.println(str1.equalsIgnoreCase(str2));
		System.out.println(str1.equalsIgnoreCase(str3));
		System.out.println("----------");
		
		System.out.println(str1.endsWith(str2));
		System.out.println(str1.endsWith(str3));
		System.out.println("----------");
		
		System.out.println(str1.startsWith(str2));
		System.out.println(str1.startsWith(str3));
		System.out.println("----------");
	}
}
