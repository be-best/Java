package com.brooke03;

public class StringDemo {
	public static void main(String[] args) {
		String str = "hello";
		char[] chs = str.toCharArray();
		for(int x=0;x<chs.length;x++) {
			System.out.println(chs[x]);
		}
		System.out.println("-----------");
		
		String str1 = str.toUpperCase();
		System.out.println(str1);
		System.out.println("-----------");
		
		String str2 = str1.toLowerCase();
		System.out.println(str2);
		System.out.println("-----------");
	}
}
