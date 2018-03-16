package myAPItest;

import java.util.Random;
/*
 * 利用随机数模拟抽签
 */
public class Test3 {
	public static void main(String[] args) {
		
		String[] team = {"巴塞罗那","拜仁慕尼黑","皇家马德里","尤文图斯","曼城","利物浦","罗马","塞维利亚"};
		int[] num = new int[8];
		int i = -1;
		for(int j=0;j<8;j++) {
			
			while(true) {
				Random r = new Random();
				boolean flag = true;
				int teamNum1 = r.nextInt(9);
				for(int x=0;x<8;x++) {
					if(num[x] == teamNum1) {
						flag = false;
						break;
						 
					}  

				}
				if(flag == true) {
					i = i+1;
					num[i] = teamNum1;
					break;
				}
			}
		}
		
		System.out.println("---模拟欧冠抽签--- ");
		System.out.println("**************");
		System.out.println("欧冠1/4决赛对阵：");
		System.out.println("--------------");
		for( i=0;i<7;i=i+2) {
			System.out.println(team[num[i]-1]+"VS"+team[num[i+1]-1]);
		}
		System.out.println("**************");
		System.out.println("最后四强：");
		System.out.println("--------------");
		for(i=0;i<7;i+=2) {
			System.out.println(team[num[i]-1]);
		}
		System.out.println("**************");
		System.out.println("半决赛对阵：");
		System.out.println("--------------");
		for(i=0;i<3;i+=2) {
			System.out.println(team[num[i]-1]+"VS"+team[num[i+4]-1]);
		}
		System.out.println("**************");
		System.out.println("基辅冠军之夜：");
		System.out.println("--------------");
		System.out.println(team[num[0]-1]+"VS"+team[num[6]-1]);
		System.out.println("**************");
		System.out.println("We are the Champion!荣耀终归："+team[num[0]-1]);
		System.out.println("————————————————————————————————");
	}
}