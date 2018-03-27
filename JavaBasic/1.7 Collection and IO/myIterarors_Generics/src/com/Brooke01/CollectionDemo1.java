package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Collection��һ���ӿ�
 * Collection��
 * 		boolean add(E e);
 * 		void clear();
 * 		boolean contains(Object o);
 * 		boolean isEmpty();
 * 		boolean remove(Object o);
 * 		int size();
 * 		Object[] toArray();
 */
public class CollectionDemo1 {
	public static void main(String[] args) {
		//boolean add(E e);
		//Collection�ǽӿڣ�����ʵ����
		Collection c = new ArrayList();	//��̬;��������ָ���������
		boolean flag1 = c.add("hello");
		boolean flag2 = c.add("world");
		System.out.println(c);
		System.out.println(flag1+" "+flag2);
		
		//�жϼ������Ƿ����ָ��Ԫ�أ�boolean contains(Object o);
		boolean flag3 = c.contains("java");
		System.out.println(flag3);
		
		//�жϼ����Ƿ�Ϊ�գ�boolean isEmpty();
		boolean flag4 = c.isEmpty();
		System.out.println(flag4);
		
		//ɾ��Ԫ�أ�boolean remove(Object o);
		boolean flag5 = c.remove("world");
		System.out.println(flag5);
		
		//���ؼ�����Ԫ�ظ�����int size();
		int num = c.size();
		System.out.println(num);
		
		//������ת��Ϊһ��Object���͵����飺 Object[] toArray();
		Object[] o = c.toArray();
		for(int x = 0;x < o.length;x++) {
			System.out.println(o[x]);
		}
		
		//������� void clear();
		c.clear();
		System.out.println(c);
	}
}
