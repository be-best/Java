package com.Brooke01;

public class StringBuilderTest1 {
	public static void main(String[] args) {
		StringBuilder strBui = new StringBuilder();
		strBui.append("hello").append("world");
		
		String str = strBui.toString();
		System.out.println("StringBuilder转换为String输出："+str);
		
		StringBuilder strBui1 = new StringBuilder(str);
		System.out.println("String转换为StringBuilder输出："+strBui1);
	}
}
