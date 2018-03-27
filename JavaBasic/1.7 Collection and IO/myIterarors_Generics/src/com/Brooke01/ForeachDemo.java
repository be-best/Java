package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;

/*
 * foreach:��ǿforѭ����һ�����ڱ������ϻ�������
 * ��ʽ��
 * 		for(Ԫ�ص����ͱ��������ϻ����������) {
 * 				����ֱ��ʹ�ñ���;
 * 		}
 * 
 * ��ǿforѭ���в����޸ļ��ϣ��������ֲ����޸��쳣
 * 
 * public Interface Iterator<T>
 * ʵ������ӿ���������Ϊ"foreach"����Ŀ��
 * 
 */
public class ForeachDemo {
	public static void main(String[] args) {
		//�������϶���
		Collection<String> c = new ArrayList<String>();
		c.add("hello");
		c.add("world");
		c.add("java");
		//��ǿforѭ��
		for(Object obj : c) {
			System.out.println(obj);
		}
		for(String s : c) {
			System.out.println(s.toUpperCase());
		}
	}
}
