package bull.abnormal;
/*
 * 处理多个异常
 */
public class AbnormalDemo2 {
	public static void main(String[] args) {
		try{
			String str = null;
			System.out.println(str.length());
			
			int[] num = new int[5];
			System.out.println(num[6]);
			
		}catch(NullPointerException np) {
			System.out.println("空指针异常");
		}catch(ArrayIndexOutOfBoundsException a) {
			System.out.println("数组越界");
		}catch(Exception e) {
			System.out.println("出现异常");
		}
		
	}
}
