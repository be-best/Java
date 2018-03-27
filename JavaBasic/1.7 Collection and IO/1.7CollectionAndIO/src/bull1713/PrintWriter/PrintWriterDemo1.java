package bull1713.PrintWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * ��ӡ�������й���
 * 		�Զ�����,ʹ��println()����ʵ���Զ�����
 * 		�Զ�ˢ��
 * 
 * ����FileWriter����ʱ��boolean�������Ƿ�׷��
 * ����PrintWriter����ʱ��boolean�������Ƿ��Զ�ˢ��
 */
public class PrintWriterDemo1 {
	public static void main(String[] args) throws IOException {
		method1();
		method2();
		
	}

	private static void method2() throws IOException {
		//������ӡ������
		//true��������Զ�ˢ��
		PrintWriter pw = new PrintWriter(new FileWriter("pwd.txt"),true);
		pw.println("java");
		pw.println("android");
		//ʡ��ˢ�²���
		//pw.flush();
		
		pw.close();
	}

	private static void method1() throws FileNotFoundException {
		//������ӡ������
		PrintWriter pw = new PrintWriter("pwd.txt");
		
		pw.println("hello");
		pw.println("world");
		//�ͷ���Դ
		pw.close();
	}
}
