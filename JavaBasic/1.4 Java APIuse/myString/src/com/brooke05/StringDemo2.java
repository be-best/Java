package com.brooke05;

import java.util.Scanner;

public class StringDemo2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = sc.nextLine();
		System.out.println("反转后的字符串：");
		String str1 = reserve1(str);
		String str2 = reserve2(str);
		System.out.println(str1);
		System.out.println(str2);
	}
	
	//直接倒着遍历数组
	public static String reserve1(String str) {
		String str1 = "";
		for(int x=(str.length()-1);x>=0;x--) {
			str1 += str.charAt(x);
		}
		return str1;
	}
	
	//转换为字符数组后反转，然后再把字符数组转回字符串
	public static String reserve2(String str) {
		//转换为字符数组
		char[] str2 = str.toCharArray();
		//数组反转
		for(int start=0,end=str2.length-1;start<=end;start++,end--) {
			char temp = str2[start];
			str2[start] = str2[end];
			str2[end] = temp;
		}
		String str1 = new String(str2);
		return str1;
	}
}
