package bull1711.CopyIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * �ֽ���
 */
public class IODemo2 {
	public static void main(String[] args) throws IOException {
		//�����ֽ�����������
		FileInputStream fis = new FileInputStream("RecursiveDemo1.java");
		//�����ֽ����������
		FileOutputStream fos = new FileOutputStream("IODemo2.txt");
		
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
			fos.write(by,0,len);
			fos.flush();
		}
		
		fis.close();
		fos.close();
	}
}
