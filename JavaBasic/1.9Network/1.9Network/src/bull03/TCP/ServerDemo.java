package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * �����
 * 
 * TCP���նˣ�
 * 	�������ն�Socket����
 *  ������������
 *  ��ȡ����������
 *  ��ȡ����
 *  �������
 *  �ͷ���Դ	
 */
public class ServerDemo {
	public static void main(String[] args) throws IOException {
		//�������ն�Socket����
		ServerSocket ss = new ServerSocket(10000);
		//������������
		Socket s = ss.accept();
		//��ȡ����������
		InputStream is = s.getInputStream();
		//��ȡ����
		//��ȡip
		InetAddress address = s.getInetAddress();
		//��ȡ�ֽڳ��ȣ��������һ������,�����Ŷ�ȡ������
		byte[] data = new byte[1024];
		int len = is.read(data);
		//�������
		System.out.println("sender-->"+address.getHostAddress());
		System.out.println(new String(data,0,len));
		
		//�ͷ���Դ
		s.close();
		//ss.close();//���Բ��ͷţ������һ�㲻�ر�
	}
}
