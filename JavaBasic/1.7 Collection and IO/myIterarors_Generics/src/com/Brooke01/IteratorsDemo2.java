package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/*
 * �жϼ������Ƿ���Ԫ��java������������Ԫ��android
 * �����������ڼ��ϣ��൱�ڼ��ϵ�һ�����������������ͼ��ϲ���ʱ��������ֺͼ��ϲ�һ����������쳣
 */
public class IteratorsDemo2 {
	public static void main(String[] args) {
		method1();
		method2();
	}
	//���õ���������
	private static void method2() {
		//�������϶��󣬲��ܼ�����Collection����Ϊ���ܿ����������г�Ա��
		List l = new ArrayList();
		l.add("hello");
		l.add("world");
		l.add("java");
		ListIterator it = l.listIterator();
		while(it.hasNext()) {
			String str = (String)it.next();
			if(str.equals("java")) {
				it.add("android");
			}
		}
		System.out.println(l);
	}
	//����contains����
	private static void method1() {
		//�������϶���
		Collection c = new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("java");
		if(c.contains("java")) 
			c.add("android");
		System.out.println(c);
	}
}
