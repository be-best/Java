package com.Brooke02;
/*
 * 工具类中的成员方法为静态的，所以这边调用工具类中的成员方法就不用创建对象了。
 * 直接用类调用静态成员方法，如：int max = MyArrays.getMax(array);
 * 
 * 如果工具类中的成员方法是非静态的，还要创建对象调用成员方法
 * 比如:Student stu = new Student();
 * 	   String name = stu.getName();
 */
public class MyArraysDemo {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8};
		int max = MyArrays.getMax(array);
		int index = MyArrays.getIndex(array, 6);
		System.out.println(max+"---"+index);
	}
}
