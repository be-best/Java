package com.brooke01;

public class StringDemo {
	public static void main(String[] args) {
		//方式一
		String str1 = new String("helloworld");
		System.out.println("str1:"+str1);
		
		//方式二
		char[] chs = {'h','e','l','l','o'};
		String str2 = new String(chs);
		System.out.println("str2:"+str2);
		
		//方式三
		String str3 = new String(chs,1,4);
		System.out.println("str3:"+str3);
		
		//方式四
		String str4 = "hello";
		System.out.println("str4:"+str4);
	}
}
