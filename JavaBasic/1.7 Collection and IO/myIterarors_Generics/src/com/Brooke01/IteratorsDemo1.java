package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * ������
 * 	1.toArray();���԰Ѽ���ת��Ϊ����Ȼ��������鼴��
 * 	2.iterator();���Է���һ������������Ȼ��ͨ����������������������
 * 		E next()  :������һ��Ԫ��
 * 		boolean hasNext()  :�ж��Ƿ���Ԫ�ؿ��Ի�ȡ
 */
public class IteratorsDemo1 {
	public static void main(String[] args) {
		//�������϶���
		Collection c = new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("java");
		//toArray();
		Object[] o = c.toArray();
		for(int x = 0;x < o.length;x++) {
			System.out.println(o[x]);
		}
		System.out.println("-------");
		
		//iterator();
		Iterator i = c.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
}
