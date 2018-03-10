package myRandom;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(100)+1;
		while(true){
			System.out.println("请输入你要猜的数据：");
			Scanner sc = new Scanner(System.in);
			int guessNumber = sc.nextInt();
				if(guessNumber == num){
					System.out.println("你猜对了");
					
			}
				if(guessNumber < num){
					System.out.println("你猜的数字小了");
					
			}
				if(guessNumber > num){
					System.out.println("你猜的数字大了");
					
			}
		}
	}
}


