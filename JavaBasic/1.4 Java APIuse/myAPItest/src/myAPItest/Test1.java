package myAPItest;

/*
 * �����������󣬲��ô���ʵ��
 * 1.����¼��һ�����ַ���,��¼��һ��С�ַ���
 * 2.ͳ��С�ַ����ڴ��ַ����г��ֵĴ���
 * 3.�������д�ӡ��ʽ:
 *  ��������ַ���:woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma
 *  ������С�ַ���:heima
 * ����̨���:С�ַ���heima,�ڴ��ַ���woaiheima,heimabutongyubaima,wulunheimahaishibaima,zhaodaogongzuojiushihaoma�й�����3��
 * 
 * 
 * 1��int indexOf(String str) �����ص�һ�γ��ֵ�ָ�����ַ����ڴ��ַ����е������� 
 * 2��int indexOf(String str, int startIndex)����ָ������������ʼ�����ص�һ�γ��ֵ�ָ�����ַ����ڴ��ַ����е������� 
 * 3��int lastIndexOf(String str) �������ڴ��ַ��������ұ߳��ֵ�ָ�����ַ����������� 
 * 4��int lastIndexOf(String str, int startIndex) ����ָ������������ʼ��������������ڴ��ַ��������һ�γ��ֵ�ָ�����ַ�����������
 */
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//�����һ���ַ���
		System.out.println("�������һ���ַ�����");
		String str1 = sc.nextLine();
		//����ڶ����ַ���
		System.out.println("������ڶ����ַ�����");
		String str2 = sc.nextLine();
		
		int count = getCount(str1,str2);
		System.out.println();System.out.println("С�ַ���" + str2 + ",�ڴ��ַ���" + str1 + "�й�����" + count + "��");
		
	}
	public static int getCount(String str1,String str2) {
		int index = 0;
		int count = 0;
		//��ָ������������ʼ�����ص�һ�γ��ֵ�ָ�����ַ����ڴ��ַ����е������� 
		while((index = str1.indexOf(str2, index)) != -1) {
			index = str2.length()+index;//�൱�ڿ�ȥС�ַ������ȼ�����һ�β���
			count++;
		}
		return count;
		
	}
}