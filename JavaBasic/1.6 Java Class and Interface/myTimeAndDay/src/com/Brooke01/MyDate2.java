package com.Brooke01;

import java.util.Date;

/*
 * Date�ĳ��÷���
 * 		����---Date
 * 			����ֵ��void,������long
 * 			void setTime(long time)
 * 			Date(long date)
 * 		Date---����
 * 			����long���޲���
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
