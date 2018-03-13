package myArrayList;
/*
 * ArrayList数组的遍历
 */
import java.util.ArrayList;

public class ArrarListDemo3 {
	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<String>();
		arr.add("hello");
		arr.add("world");
		arr.add("java");
		
		for(int x=0;x<arr.size();x++) {
			String str = arr.get(x);
			System.out.println(str);
		}
	}
}
