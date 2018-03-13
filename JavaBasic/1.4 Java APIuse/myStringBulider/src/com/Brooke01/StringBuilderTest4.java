package com.Brooke01;
/*
 * ÅĞ¶Ï×Ö·û´®ÊÇ·ñ¶Ô³Æ
 */
import java.util.Scanner;

public class StringBuilderTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÒ»¸ö×Ö·û´®£º");
		String str = sc.nextLine();
		boolean b = isSymmetry(str);
		System.out.println("ÊÇ·ñ¶Ô³Æ£º"+b);
	}
	public static boolean isSymmetry(String str) {
		StringBuilder strBui = new StringBuilder(str);
		strBui.reverse();
		String strRes = strBui.toString();
		return strRes.equals(str);
	}
}
