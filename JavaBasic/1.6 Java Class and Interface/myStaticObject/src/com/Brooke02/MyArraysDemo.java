package com.Brooke02;
/*
 * �������еĳ�Ա����Ϊ��̬�ģ�������ߵ��ù������еĳ�Ա�����Ͳ��ô��������ˡ�
 * ֱ��������þ�̬��Ա�������磺int max = MyArrays.getMax(array);
 * 
 * ����������еĳ�Ա�����ǷǾ�̬�ģ���Ҫ����������ó�Ա����
 * ����:Student stu = new Student();
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
