package bull03.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class ClientDemo2 {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//�����ͻ���Socket����
		Socket s  = new Socket(InetAddress.getByName("DESKTOP-ICVMAGQ"),1234);
		//��ȡ���������
		OutputStream os = s.getOutputStream();
		//��������
		//String str = "hello java!";
		byte[] data = "hello java!".getBytes();
		os.write(data);
		
		//���շ���˷��ص�����
		//��ȡ����������
		InputStream is = s.getInputStream();
		//��ȡ����,�������һ������,�����Ŷ�ȡ������
		byte[] datas = new byte[1024];
		int len = is.read(datas);
		
		//�������
		System.out.println(new String(datas,0,len));
		
		//�ͷ���Դ
		os.close();
		s.close();
	}
}
