package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 * 
 * TCP�������ݣ�
 * 	�������Ͷ�Socket����
 *  ��ȡ���������
 *  ��������
 *  �ͷ���Դ
 */
public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//�������Ͷ�Socket����
		Socket s = new Socket(InetAddress.getByName("DESKTOP-ICVMAGQ"), 10000);
		
		//��ȡ���������
		OutputStream os = s.getOutputStream();
		
		//��������
		byte[] data = "hello java world".getBytes();
		os.write(data);
	
		
		//�ͷ���Դ
		os.close();//��д�ɲ�д����ΪSocketҲ���æ�ͷ�
		s.close();
	}
}
