package com.Brooke01;

public class StringBuilderDemo2 {
	public static void main(String[] args) {
		StringBuilder strBui = new StringBuilder();
		//��ʽ��̣�ƴ��
		strBui.append(true).append("abc").append(100);
		System.out.println(strBui);
		//��ת
		System.out.println(strBui.reverse());
	}
}
