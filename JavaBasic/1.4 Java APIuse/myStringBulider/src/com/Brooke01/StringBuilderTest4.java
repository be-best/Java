package com.Brooke01;
/*
 * �ж��ַ����Ƿ�Գ�
 */
import java.util.Scanner;

public class StringBuilderTest4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str = sc.nextLine();
		boolean b = isSymmetry(str);
		System.out.println("�Ƿ�Գƣ�"+b);
	}
	public static boolean isSymmetry(String str) {
		StringBuilder strBui = new StringBuilder(str);
		strBui.reverse();
		String strRes = strBui.toString();
		return strRes.equals(str);
	}
}
