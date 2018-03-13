package com.Brooke01;
/*
 * 数组元素按格式拼接
 */
public class StringBuilderTest2 {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		String str = arrToString(arr);
		System.out.println("拼接后的字符串："+str);
	}
	public static String arrToString(int[] arr) {
		StringBuilder strBui = new StringBuilder();
		strBui.append("[");
		for(int x=0;x<arr.length;x++) {
			if(x == arr.length-1) {
				strBui.append(arr[x]);
			}
			else {
				strBui.append(arr[x]).append(",");
			}
		}
		strBui.append("]");
		String str = strBui.toString();
		return str;
	}
}
