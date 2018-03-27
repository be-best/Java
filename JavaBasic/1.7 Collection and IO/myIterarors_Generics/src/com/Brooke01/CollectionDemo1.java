package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Collection是一个接口
 * Collection：
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
		//Collection是接口，不能实例化
		Collection c = new ArrayList();	//多态;父类引用指向子类对象
		boolean flag1 = c.add("hello");
		boolean flag2 = c.add("world");
		System.out.println(c);
		System.out.println(flag1+" "+flag2);
		
		//判断集合中是否包含指定元素：boolean contains(Object o);
		boolean flag3 = c.contains("java");
		System.out.println(flag3);
		
		//判断集合是否为空：boolean isEmpty();
		boolean flag4 = c.isEmpty();
		System.out.println(flag4);
		
		//删除元素：boolean remove(Object o);
		boolean flag5 = c.remove("world");
		System.out.println(flag5);
		
		//返回集合中元素个数：int size();
		int num = c.size();
		System.out.println(num);
		
		//将集合转换为一个Object类型的数组： Object[] toArray();
		Object[] o = c.toArray();
		for(int x = 0;x < o.length;x++) {
			System.out.println(o[x]);
		}
		
		//清除功能 void clear();
		c.clear();
		System.out.println(c);
	}
}
