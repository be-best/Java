package bull.abnormal;

import java.io.FileWriter;
import java.io.IOException;

/*
 * ��ʽһ��
 * try {
 * 		�п��ܳ�������Ĵ��룻
 * }catch(ArithmeticException ae) {
 * 		�����쳣��
 * }
 * 
 * try...catch��ִ��˳��
 * 		��ִ��try��䷢���쳣���쳣����Ĵ��벻ִ�У�ֱ������catch���,Ȼ��try...catchִ�н���;
 * 		���û���쳣��ִ��try��䣬��ִ��catch���;
 * 
 * ��ʽ�������쳣
 * 		�����ǲ��봦���û��������ʱ������ѡ�����쳣��˭���÷���˭�����쳣
 * 		ʹ�ùؼ���throws�ڷ����������׳��쳣
 */
public class AbnormalDemo1 {
	public static void main(String[] args) throws IOException {
		method1();
		method2();
	}

	private static void method2() throws IOException {
		FileWriter fw = new FileWriter("test.txt");
	}

	private static void method1() {
		try {
			System.out.println(1+2);
			System.out.println(9/0);
			System.out.println(1+1);
		} catch(ArithmeticException ae) {
			System.out.println("��������Ϊ0");
		}
		System.out.println("����");
	}
}
