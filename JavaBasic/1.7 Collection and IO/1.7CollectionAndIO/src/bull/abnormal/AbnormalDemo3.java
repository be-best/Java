package bull.abnormal;
/*
 * throwable的使用方法
 */
public class AbnormalDemo3 {
	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		try {
			System.out.println(2/0);
		}catch(ArithmeticException ae) {
			//String getMessage();原因
			System.out.println(ae.getMessage());
			//String toString();类型和原因
			System.out.println(ae.toString());
			//void printStackTrace();类型原因和位置
			ae.printStackTrace();
		}
	}
}
