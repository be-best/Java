package com.Brooke01;

import java.util.Calendar;

/*
 * Calendar��
 * 
 * ��ȡ
 * �޸�
 * ���
 */
public class MyCalendar {
	public static void main(String[] args) {
		method1();
		method2();
		method3();
		
	}

	private static void method3() {
		//void add(int field,int amount);��ָ�����ֶ��ϼ���ָ����ֵ
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"��"+month+"��"+day+"��");
	}

	private static void method2() {
		Calendar c = Calendar.getInstance();
		//void set(int field,int value);��ָ�����ֶ��޸ĳ�ָ����ֵ
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"��"+month+"��"+day+"��");
	}

	private static void method1() {
		//static Calendar getInstance();��static�����Ǿ�̬����
		//��Ϊ�Ǿ�̬�������Կ���ֱ���������
		Calendar c = Calendar.getInstance();
		//int get(int field);���ظ��������ֶ�ֵ
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"��"+month+"��"+day+"��");
	}
}
