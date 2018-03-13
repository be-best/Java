package com.Brooke01;
/*
 * String字符串转为StringBuilder并反转再转回String输出
 */
import java.util.Scanner;

public class StringBuilderTest3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串：");
		String str = sc.nextLine();
		String strRes = myReserve(str);
		System.out.println("反转后的字符串是："+strRes);
	}
	public static String myReserve(String str) {
		StringBuilder strBui = new StringBuilder(str);
		strBui.reverse();
		String str1 = strBui.toString();
		return str1;
	}
}
