package myAPItest;

import java.util.Random;
/*
 * ���������ģ���ǩ
 */
public class Test3 {
	public static void main(String[] args) {
		
		String[] team = {"��������","����Ľ���","�ʼ������","����ͼ˹","����","������","����","��ά����"};
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
		
		System.out.println("---ģ��ŷ�ڳ�ǩ--- ");
		System.out.println("**************");
		System.out.println("ŷ��1/4��������");
		System.out.println("--------------");
		for( i=0;i<7;i=i+2) {
			System.out.println(team[num[i]-1]+"VS"+team[num[i+1]-1]);
		}
		System.out.println("**************");
		System.out.println("�����ǿ��");
		System.out.println("--------------");
		for(i=0;i<7;i+=2) {
			System.out.println(team[num[i]-1]);
		}
		System.out.println("**************");
		System.out.println("���������");
		System.out.println("--------------");
		for(i=0;i<3;i+=2) {
			System.out.println(team[num[i]-1]+"VS"+team[num[i+4]-1]);
		}
		System.out.println("**************");
		System.out.println("�����ھ�֮ҹ��");
		System.out.println("--------------");
		System.out.println(team[num[0]-1]+"VS"+team[num[6]-1]);
		System.out.println("**************");
		System.out.println("We are the Champion!��ҫ�չ飺"+team[num[0]-1]);
		System.out.println("����������������������������������������������������������������");
	}
}