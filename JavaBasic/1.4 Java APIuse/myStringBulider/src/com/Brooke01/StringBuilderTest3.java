package com.Brooke01;
/*
 * String�ַ���תΪStringBuilder����ת��ת��String���
 */
import java.util.Scanner;

public class StringBuilderTest3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ַ�����");
		String str = sc.nextLine();
		String strRes = myReserve(str);
		System.out.println("��ת����ַ����ǣ�"+strRes);
	}
	public static String myReserve(String str) {
		StringBuilder strBui = new StringBuilder(str);
		strBui.reverse();
		String str1 = strBui.toString();
		return str1;
	}
}
