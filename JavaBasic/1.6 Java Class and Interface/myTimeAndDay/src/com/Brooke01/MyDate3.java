package com.Brooke01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 格式化和解析
 */
public class MyDate3 {
	public static void main(String[] args) throws ParseException {
		method1();
		System.out.println("-----------------------");
		method2();
	}

	private static void method2() throws ParseException {
		//SimpleDateFormat(Date date);可自定义格式
		//格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");
		//创建Date对象
		Date d = new Date();
		
		String s = sdf.format(d);
		System.out.println(s);
		
		//解析
		Date d1 = sdf.parse(s);
		System.out.println(d1.toLocaleString());
	}

	private static void method1() throws ParseException {
		//SimpleDateFormat();默认格式
		//格式化
		SimpleDateFormat sdf = new SimpleDateFormat();
		//创建Date对象
		Date d = new Date();
		String s = sdf.format(d);
		System.out.println(s);
		
		//解析
		Date d1 = sdf.parse(s);
		System.out.println(d.toLocaleString());
	}
}
