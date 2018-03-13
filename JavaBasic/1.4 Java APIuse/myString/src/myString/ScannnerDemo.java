package myString;

import java.util.Scanner;

public class ScannnerDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String str = sc.nextLine();
		System.out.println(num+str);
	}
}
