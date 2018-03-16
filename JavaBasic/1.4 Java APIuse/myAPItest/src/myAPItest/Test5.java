package myAPItest;

import java.util.Random;

/*
 * 1.定义String getStr()方法
 * 功能描述：获取长度为5的随机字符串，字符串由随机的4个大写英文字母和1个0-9之间（包含0和9）的整数组成
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
//		这样创建26个字符数组太麻烦,我们可以通过循环来解决
//		char[] chs = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
//				'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
//		*/
//		char[] chs = new char[26];
//		int index = 0;
//		// 通过循环,获取所有大写字母
//		for(int i='A'; i<='Z'; i++){ // 由于i是int类型,当循环的时候,i值为65
//			// 将大写字母的int类型变现形式强转成字符类型
//			chs[index++] = (char)i;
//		}
//		String str = getStr(chs);
//		System.out.println(str);
//	}
//	
//	/*
//	 * 获取字符串方法
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
