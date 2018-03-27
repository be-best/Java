package bull1711.CopyIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ʹ���ֽ��������ı��ļ�
 */
public class IODemo4 {
	public static void main(String[] args) throws IOException {
		//�������������
		FileOutputStream fos = new FileOutputStream("IODemo4.txt");
		//��������������
		FileInputStream fis = new FileInputStream("IODemo2.txt");
		
		//һ�ζ�дһ���ֽ�
		int ch;
		while((ch = fis.read()) != -1) {
			fos.write(ch);
			fos.flush();
		}
		
		//һ�ζ�дһ���ֽ�����
		byte[] by = new byte[1024];
		int len;
		while((len = fis.read(by)) != -1) {
			fos.write(by, 0, len);
			fos.flush();
		}
		
		//�ͷ���Դ
		fis.close();
		fos.close();
	}
}
