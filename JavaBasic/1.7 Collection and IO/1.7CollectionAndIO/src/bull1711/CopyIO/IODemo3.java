package bull1711.CopyIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * �����ֽ�������ͼƬ
 * 
 * �������ļ���ʹ��windows�Դ����±��������ģ�ֻ�����ֽ������и���
 * �ı��ļ��ȿ����ֽ���Ҳ�����ַ���
 */
public class IODemo3 {
	public static void main(String[] args) throws IOException {
		//��������������
		FileInputStream fis = new FileInputStream("1.jpg");
		//�������������
		FileOutputStream fos = new FileOutputStream("copyD3.jpg");
		
		//һ�ζ�дһ���ֽ�����
		byte[] by = new byte[1024];
		int len;
		while((len = fis.read(by)) != -1) {
			fos.write(by,0,len);
		}
		
		//�ͷ���Դ
		fis.close();
		fos.close();
	}

}
