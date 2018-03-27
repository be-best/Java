package com.Brooke01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
 * 遍历：
 * 	1.toArray();可以把集合转换为数组然后遍历数组即可
 * 	2.iterator();可以返回一个迭代器对象，然后通过迭代器对象来迭代集合
 * 		E next()  :返回下一个元素
 * 		boolean hasNext()  :判断是否有元素可以获取
 */
public class IteratorsDemo1 {
	public static void main(String[] args) {
		//创建集合对象
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
