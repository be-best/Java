package myArrayList;
/*
 * 定义字符数组，将数组元素加到集合中
 * 输出姓张的人
 * 
 */
import java.util.ArrayList;

public class ArrayListTest2 {
	public static void main(String[] args) {
		String[] arr = {"张一","王二","张三","李四","张五"};
		ArrayList<String> array = new ArrayList<String>();
		for(int x=0;x<arr.length;x++) {
			array.add(arr[x]);
		}
		for(int x=0;x<array.size();x++) {
			String str = array.get(x);
			if(str.startsWith("张")){
				System.out.println(str);
			}
		}
	}
}
