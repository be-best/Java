package myInteger;
/*
 * 正则表达式
 * 
 * 验证QQ号码
 *  	1.不以0开头
 *  	2.5-15位
 *  	3.全是数字
 */
public class RegularDemo {
	public static void main(String[] args) {
		//不采用正则表达式
		String str = "123456";
		boolean flag1 = checkQQ(str);
		System.out.println(flag1);
		
		//采用正则表达式
		boolean flag2 = str.matches("[1-9][0-9]{4,14}");
		System.out.println(flag2);
	}
	
	public static boolean checkQQ(String qq) {
		//判断5-15位
		int length = qq.length();
		if(length < 5 || length > 15) {
			return false;
		}
		//判断是否以0开头
		if(qq.startsWith("0")) {
			return false;
		}
		//判断是否全是数字
		for(int x = 0;x < length;x++) {
			char c = qq.charAt(x);
			if(c<'0' || c>'9') {
				return false;
			}
		}
		return true;
	}
}
