package com.zws;

/*
 * ��ʽ�����ĸı䲻Ӱ��ʵ�ʲ����ĸı�
 * ��ʽ���������ڽ���ʵ�ʲ����ı���
 * ʵ�ʲ�����ʵ�ʲ�������ı���
 */
public class MethodDemo6 {
	public static void main(String[] args) {
		int a = 10;  //ʵ�ʲ���
		int b = 20;  //ʵ�ʲ���
		System.out.println("a:"+a+",b:"+b);
		change(a,b);
		System.out.println("a:"+a+",b:"+b);
	}
	public static void change(int a,int b){ //����a,bΪ��ʽ����
		a = a+30;
		b = b+40;
		System.out.println("a:"+a+",b:"+b);
	}
}
