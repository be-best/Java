package bull1712.IOstream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/*
 * ��ȡ����¼�����ݲ��洢��ָ���ļ���
 * 
 * ת������InputStreamReader
 *    	���ֽ�������ת��Ϊ�ַ�������		
 */
public class IOStreamDemo2 {
	public static void main(String[] args) throws IOException {
		//�����ֽ����鷽ʽ
		method1();
		//����InputStreamReader�����ֽ�������ת��Ϊ�ַ�������	
		method2();
	}

	private static void method2() throws IOException {
		//��������������
		//InputStream is = System.in;
		Reader r = new InputStreamReader(System.in);
		//�������������
		FileWriter fw = new FileWriter("a.txt");
		
		char[] chs = new char[1024];
		int len;
		while((len = r.read(chs)) != -1) {
			fw.write(chs, 0, len);
			fw.flush();
		}
		//�ͷ���Դ
		fw.close();
		r.close();
	}

	private static void method1() throws IOException {
		//��������������
		InputStream is = System.in;
		//�������������
		FileWriter fw = new FileWriter("a.txt");
		
		byte[] by = new byte[1024];
		int len;
		while((len = is.read(by)) != -1) {
			//new String();���ֽ�����ת��Ϊ�ַ���.ע��(by,0,len)�ĸ�ʽ
			fw.write(new String(by,0,len));
			fw.flush();
		}
		//�ͷ���Դ
		fw.close();
		is.close();
	}
}
