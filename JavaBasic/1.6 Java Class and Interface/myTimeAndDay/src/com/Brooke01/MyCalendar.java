package com.Brooke01;

import java.util.Calendar;

/*
 * Calendar类
 * 
 * 获取
 * 修改
 * 添加
 */
public class MyCalendar {
	public static void main(String[] args) {
		method1();
		method2();
		method3();
		
	}

	private static void method3() {
		//void add(int field,int amount);在指定的字段上加上指定的值
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, -1);
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
	}

	private static void method2() {
		Calendar c = Calendar.getInstance();
		//void set(int field,int value);把指定的字段修改成指定的值
		c.set(Calendar.DAY_OF_MONTH, 15);
		
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
	}

	private static void method1() {
		//static Calendar getInstance();有static所以是静态方法
		//因为是静态方法所以可以直接用类调用
		Calendar c = Calendar.getInstance();
		//int get(int field);返回给定日历字段值
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(year+"年"+month+"月"+day+"日");
	}
}
