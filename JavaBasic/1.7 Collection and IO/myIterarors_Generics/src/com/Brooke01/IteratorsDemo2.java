package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

/*
 * 判断集合中是否含有元素java，如果有则添加元素android
 * 迭代器依赖于集合，相当于集合的一个副本，当迭代器和集合操作时，如果发现和集合不一样，则出现异常
 */
public class IteratorsDemo2 {
	public static void main(String[] args) {
		method1();
		method2();
	}
	//采用迭代器方法
	private static void method2() {
		//创建集合对象，不能继续用Collection，因为不能看到子类特有成员。
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
	//采用contains方法
	private static void method1() {
		//创建集合对象
		Collection c = new ArrayList();
		c.add("hello");
		c.add("world");
		c.add("java");
		if(c.contains("java")) 
			c.add("android");
		System.out.println(c);
	}
}
