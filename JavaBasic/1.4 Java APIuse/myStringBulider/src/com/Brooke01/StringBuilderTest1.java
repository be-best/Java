package com.Brooke01;

public class StringBuilderTest1 {
	public static void main(String[] args) {
		StringBuilder strBui = new StringBuilder();
		strBui.append("hello").append("world");
		
		String str = strBui.toString();
		System.out.println("StringBuilderת��ΪString�����"+str);
		
		StringBuilder strBui1 = new StringBuilder(str);
		System.out.println("Stringת��ΪStringBuilder�����"+strBui1);
	}
}
