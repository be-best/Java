package myInteger;
/*
 * ������ʽ
 * 
 * ��֤QQ����
 *  	1.����0��ͷ
 *  	2.5-15λ
 *  	3.ȫ������
 */
public class RegularDemo {
	public static void main(String[] args) {
		//������������ʽ
		String str = "123456";
		boolean flag1 = checkQQ(str);
		System.out.println(flag1);
		
		//����������ʽ
		boolean flag2 = str.matches("[1-9][0-9]{4,14}");
		System.out.println(flag2);
	}
	
	public static boolean checkQQ(String qq) {
		//�ж�5-15λ
		int length = qq.length();
		if(length < 5 || length > 15) {
			return false;
		}
		//�ж��Ƿ���0��ͷ
		if(qq.startsWith("0")) {
			return false;
		}
		//�ж��Ƿ�ȫ������
		for(int x = 0;x < length;x++) {
			char c = qq.charAt(x);
			if(c<'0' || c>'9') {
				return false;
			}
		}
		return true;
	}
}
