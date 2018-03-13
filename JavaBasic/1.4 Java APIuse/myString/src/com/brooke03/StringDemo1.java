package com.brooke03;
/*
 * 字母字符串中，首字母转为大写其他小写
 */
import java.util.Scanner;

public class StringDemo1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = sc.nextLine();
		//截取首字母
		String str1 = str.substring(0,1);
		str1 = str1.toUpperCase();
		//截取剩余字符
		String str2 = str.substring(1, str.length());
		str2 = str2.toLowerCase();
		System.out.println("转换后的字符串是：");
		System.out.println(str1+str2);
	}
}
