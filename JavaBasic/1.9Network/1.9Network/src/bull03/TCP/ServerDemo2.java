package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * �����
 */
public class ServerDemo2 {
	public static void main(String[] args) throws IOException {
		//���������Socket����
		ServerSocket ss = new ServerSocket(1234);
		//������������
		Socket s = ss.accept();
		//��ȡ����������
		InputStream is = s.getInputStream();
		//��ȡ����
		//ip
		InetAddress address = s.getInetAddress();
		//���ݣ��������һ������,�����Ŷ�ȡ������
		byte[] data = new byte[1024];
		int len = is.read(data);
		//�������
		System.out.println(new String(data,0,len));
		
		//�������ݷ��ؿͻ���
		//��ȡ���������
		OutputStream os = s.getOutputStream();
		//ת���ɴ�д����������
		String str = new String(data,0,len);
		String stru = str.toUpperCase();
		os.write(stru.getBytes());
		
		//�ͷ���Դ
		s.close();
		//ss.close();//�����һ�㲻�ر�
	}
}
