package myAPItest;

import java.util.Random;

/*
 * 1.����String getStr()����
 * ������������ȡ����Ϊ5������ַ������ַ����������4����дӢ����ĸ��1��0-9֮�䣨����0��9�����������
 */
public class Test5 {
	public static void main(String[] args) {
		Random rd = new Random();
		char[] chs = new char[26];
		int index = 0;
		for(int i='A';i<='Z';i++) {
			chs[index] = (char)i;
			index++;
		}
		int num = rd.nextInt(10);
		String str = getStr(chs);
		System.out.println(str+num);
	}
	public static String getStr(char[] chs) {
		Random rd = new Random();
		StringBuilder sb = new StringBuilder();
		for(int x=0;x<4;x++) {
			int strNum = rd.nextInt(26);
			sb.append(chs[strNum]);
		}
		
		String str =sb.toString();
		return str;
	}
}

//public class Test5 {
//	public static void main(String[] args) {
//		/*
//		��������26���ַ�����̫�鷳,���ǿ���ͨ��ѭ�������
//		char[] chs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
//				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//		*/
//		char[] chs = new char[26];
//		int index = 0;
//		// ͨ��ѭ��,��ȡ���д�д��ĸ
//		for(int i='A'; i<='Z'; i++){ // ����i��int����,��ѭ����ʱ��,iֵΪ65
//			// ����д��ĸ��int���ͱ�����ʽǿת���ַ�����
//			chs[index++] = (char)i;
//		}
//		String str = getStr(chs);
//		System.out.println(str);
//	}
//	
//	/*
//	 * ��ȡ�ַ�������
//	 */
//	private static String getStr(char[] chs) {
//		Random r = new Random();
//		
//		StringBuilder sb = new StringBuilder();
//		
//		for(int i=0; i<4; i++){
//			int random = r.nextInt(chs.length);
//			sb.append(chs[random]);
//		}
//		
//		sb.append(r.nextInt(10));
//		
//		return sb.toString();
//	}
//}
