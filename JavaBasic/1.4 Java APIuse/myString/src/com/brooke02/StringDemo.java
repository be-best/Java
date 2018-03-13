package com.brooke02;

public class StringDemo {
	public static void main(String[] args) {
		String str = "helloworld";
		
		System.out.println(str.length());
		System.out.println("-----------");
		
		System.out.println(str.charAt(2));
		System.out.println(str.charAt(3));
		System.out.println("-----------");
		
		System.out.println(str.indexOf("l"));
		System.out.println(str.indexOf("o"));
		System.out.println("-----------");
		
		System.out.println(str.substring(3));
		System.out.println("-----------");
		
		System.out.println(str.substring(2, 8));
	}
}
