package myRandom;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo {
	public static void main(String[] args) {
		Random r = new Random();
		int num = r.nextInt(100)+1;
		while(true){
			System.out.println("��������Ҫ�µ����ݣ�");
			Scanner sc = new Scanner(System.in);
			int guessNumber = sc.nextInt();
				if(guessNumber == num){
					System.out.println("��¶���");
					
			}
				if(guessNumber < num){
					System.out.println("��µ�����С��");
					
			}
				if(guessNumber > num){
					System.out.println("��µ����ִ���");
					
			}
		}
	}
}


