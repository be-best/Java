package bull.Landlord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Collections:
 * 		Collections与Collection的区别：
 * 		Collection是集合体系的最顶层，包含了集合体系的共性
 * 		Collections是一个工具类，方法都是用于操作Collection
 */
public class CollectionsDemo {
	public static void main(String[] args) {
		method1();
		System.out.println("-------------------");
		method2();
		System.out.println("-------------------");
		method3();
		System.out.println("-------------------");
		method4();
		System.out.println("-------------------");
		method5();
	}

	private static void method5() {
		//static void swap(List list,int i,int j);将指定列表中的两个索引进行位置互换
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		//输出置换前列表
		System.out.println(list);
		Collections.swap(list, 0, 3);
		//输出置换后列表
		System.out.println(list);
	}

	private static void method4() {
		//static void shuffle(List list);随机置换
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("java");
		Collections.shuffle(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}

	private static void method3() {
		//static void fill(List list,Object obj);使用指定对象填充指定列表的所有元素
		List<String> list = new ArrayList<String>();
		list.add("java");
		list.add("hello");
		list.add("world");
		Collections.fill(list, "android");
		System.out.println(list);
	}

	private static void method2() {
		//static void copy(List dest,List src);把源列表中的数据覆盖到目标列表
		                    //目标列表	               源列表
		//目标列表不能小于源列表
		//创建源列表
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("java");
		//创建目标列表
		List<String> list1 = new ArrayList<String>();
		list1.add("");
		list1.add("");
		list1.add("");
		Collections.copy(list1, list);
		System.out.println(list1);
	}

	private static void method1() {
		//static int binarySearch(List list,Object key)使用二分查找法查找指定元素在指定列表的索引位置
		//创建列表对象
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int index = Collections.binarySearch(list, 3);
		System.out.println(index);
	}
}
