package bull.abnormal;
/*
 * throwable��ʹ�÷���
 */
public class AbnormalDemo3 {
	public static void main(String[] args) {
		method1();
	}

	private static void method1() {
		try {
			System.out.println(2/0);
		}catch(ArithmeticException ae) {
			//String getMessage();ԭ��
			System.out.println(ae.getMessage());
			//String toString();���ͺ�ԭ��
			System.out.println(ae.toString());
			//void printStackTrace();����ԭ���λ��
			ae.printStackTrace();
		}
	}
}
