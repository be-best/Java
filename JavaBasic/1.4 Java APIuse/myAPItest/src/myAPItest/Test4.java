package myAPItest;

import java.util.Random;

public class Test4 {
	public static void main(String[] args) {
		Random r = new Random();
		for(int x=0;x<9;x++) {
			int num = r.nextInt(8);
			//int num =x;
			System.out.println(num);
		}
	}
}
