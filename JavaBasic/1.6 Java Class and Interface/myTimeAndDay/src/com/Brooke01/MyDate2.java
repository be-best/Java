package com.Brooke01;

import java.util.Date;

/*
 * Date的常用方法
 * 		毫秒---Date
 * 			返回值是void,参数是long
 * 			void setTime(long time)
 * 			Date(long date)
 * 		Date---毫秒
 * 			返回long，无参数
 * 			long getTime()
 */
public class MyDate2 {
	public static void main(String[] args) {
		Date d = new Date();
		d.setTime(346718);
		System.out.println(d.toLocaleString());
		System.out.println(d.getTime());
		//d.setTime(1521566189725);
	}
}
