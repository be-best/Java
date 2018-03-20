package com.Brooke01;

import java.util.Date;

/*
 * Date¿‡
 */
public class MyDate {
	public static void main(String[] args) {
		//Date()
		Date day = new Date();
		System.out.println(day.toLocaleString());
		//Date(long date)
		System.out.println(System.currentTimeMillis());
		Date day1 = new Date();//
		System.out.println(day1.toLocaleString());
	}
}
