package com.Brooke01;

public class StaticDemo3 {
	public static void main(String[] args) {
		//static double PI:�����ֵ
		System.out.println("�����ֵ��"+Math.PI);
		
		//static double abs(double a)���ؾ���ֵ
		System.out.println("���ؾ���ֵ��"+-10+"---"+Math.abs(-10));
		
		//static double ceil(double a) ����ȡ��
		System.out.println("����ȡ��:"+1.2+"---"+Math.ceil(1.2));
		
		//static double floor(double a) ����ȡ��
		System.out.println("����ȡ��:"+1.8+"---"+Math.floor(1.8));
		
		//static long round(double a) ��������
		System.out.println("�������룺"+1.2+"---"+Math.round(1.2));
		
		//static double max(double a,double b) ȡ���
		System.out.println("ȡ���"+"(3,4)"+"---"+Math.max(3, 4));
		
		//static dpuble pow(double a,double b) ���ص�һ�������ĵڶ�����������
		System.out.println("a��b�η���"+"(3,2)"+"---"+Math.pow(3, 2));
		
		//static double random() ����һ������0С��1�������
		System.out.println("����0С��1���������"+Math.random());
	}
}
