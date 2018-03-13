package com.brooke05;
/*
 * 数组元素格式拼接
 */
public class StringDemo1 {
	public static void main(String[] args) {
		int[] str1 = {1,2,3,4,5};
		String str = arrayToString(str1);
		System.out.println(str);
	}
	public static String arrayToString(int[] str) {
		String str1 = "";
		str1 += "[";
		for(int x=0;x<str.length;x++) {
			if(x == (str.length-1)) {
				str1 += str[x];
			}
			else {
				str1 += str[x];
				str1 += ",";
			}
		}
		str1 += "]";
		return str1;
	}
	
}
