package com.Brooke01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ��ʽ���ͽ���
 */
public class MyDate3 {
	public static void main(String[] args) throws ParseException {
		method1();
		System.out.println("-----------------------");
		method2();
	}

	private static void method2() throws ParseException {
		//SimpleDateFormat(Date date);���Զ����ʽ
		//��ʽ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss");
		//����Date����
		Date d = new Date();
		
		String s = sdf.format(d);
		System.out.println(s);
		
		//����
		Date d1 = sdf.parse(s);
		System.out.println(d1.toLocaleString());
	}

	private static void method1() throws ParseException {
		//SimpleDateFormat();Ĭ�ϸ�ʽ
		//��ʽ��
		SimpleDateFormat sdf = new SimpleDateFormat();
		//����Date����
		Date d = new Date();
		String s = sdf.format(d);
		System.out.println(s);
		
		//����
		Date d1 = sdf.parse(s);
		System.out.println(d.toLocaleString());
	}
}
