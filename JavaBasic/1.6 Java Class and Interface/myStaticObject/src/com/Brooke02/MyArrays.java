package com.Brooke02;
/*
 * ������
 */
public class MyArrays {
	//���๹��˽�У�������Ͳ��ܴ��������Ķ����ˡ�
	private MyArrays() {
		
	}
	
	//�������ֵ
	public static int getMax(int[] array) {
		int max = 0;
		for(int x=0;x<array.length;x++) {
			if(array[x] > max) {
				max = array[x];
			}
		}
		return max;
	}
	
	//������ָ��ֵ��ͬ������
	public static int getIndex(int[] array,int index) {
		for(int x=0;x<array.length;x++) {
			if(array[x] == index) {
				return x;
			}
		}
		//����������û����index��ȵ�ֵ����ôreturn -1;
		return -1;
	}
}
