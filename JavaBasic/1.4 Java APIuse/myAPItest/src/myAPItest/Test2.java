package myAPItest;

import java.util.Scanner;

/*
 * ������������,���ô���ʵ��
 * 1.����¼��һ��Դ�ַ������ַ�������scrStr����
 * 2.����¼��һ��Ҫɾ�����ַ������ַ�������delStr����
 * 3.Ҫ��:ɾ������scrStr�����е�����delStr�ַ��������յ��ַ����в��ܰ���delStr����Ҫ���ӡɾ����Ľ���Լ�ɾ���˼���delStr�ַ���
 * 4.�������д�ӡ��ʽ:
 * ������Դ�ַ���:java woaijava,i like jajavava i enjoy java
 * ������Ҫɾ�����ַ���:java
 * ����̨������:Դ�ַ������ܹ�����:5 �� java ɾ��java����ַ���Ϊ: woai,i like  i enjoy
 */

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//�����һ���ַ���
		System.out.println("�������һ���ַ�����");
		String str1 = sc.nextLine();
		//����Ҫɾ�����ַ���
		System.out.println("������Ҫɾ�����ַ�����");
		String str2 = sc.nextLine();
		
		int count = 0;
		//indexOf����ָ���ַ�����һ�γ��ֵ�����
		while((str1.indexOf(str2)) != -1) {
			//��ָ���ַ���str2ɾ��
			str1 = str1.replaceFirst(str2, "");
			//����
			count++;
		}
		System.out.println("Դ�ַ���������"+count+"��"+str2+",ɾ��"+str2+"����ַ���Ϊ��"+str1);
	}

	
}
