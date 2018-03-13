package myArrayList;

import java.util.ArrayList;

public class ArrayListDemo2 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("hello");
		arr.add("world");
		arr.add("Java");
		arr.add("very");
		arr.add("good");
		
		//获取元素 public E get(int index)
		System.out.println("位置0的元素是："+arr.get(0));
		System.out.println("位置3的元素是："+arr.get(3));
		System.out.println("------------");
		
		//public int size():返回集合中的元素个数
		System.out.println(arr.size());
		System.out.println("------------");
		
		//删除元素一：public boolean remove(Object o)；删除指定元素，返回是否删除成功
		System.out.println("删除掉hello："+arr.remove("hello"));
		System.out.println("删除掉hello："+arr.remove("hello"));
		System.out.println("此时的arr:"+arr);
		System.out.println("------------");
		
		//删除元素二：public E remove(int index)；删除指定处元素，返回被删除的元素
		System.out.println("删除掉此时位置为一的元素："+arr.remove(1));
		System.out.println("此时的arr:"+arr);
		System.out.println("------------");
		
		//修改元素：public E set(int index,E element);修改指定索引处的元素，返回被修改的元素
		System.out.println("修改位置为二的元素为perfect："+arr.set(2, "perfect"));
		System.out.println("此时的arr:"+arr);
		
	}
}
