package bull.abnormal;
/*
 * �������쳣
 */
public class AbnormalDemo2 {
	public static void main(String[] args) {
		try{
			String str = null;
			System.out.println(str.length());
			
			int[] num = new int[5];
			System.out.println(num[6]);
			
		}catch(NullPointerException np) {
			System.out.println("��ָ���쳣");
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("����Խ��");
		}catch(Exception e) {
			System.out.println("�����쳣");
		}
		
	}
}
