package myArrayList;

import java.util.ArrayList;

public class ArrayListTest1 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		
		//添加字符串元素
		arr.add("梅西");
		arr.add("内马尔");
		arr.add("苏亚雷斯");
		
		for(int x=0;x<arr.size();x++) {
			String str = arr.get(x);
			System.out.println(str);
		}
	}
}
