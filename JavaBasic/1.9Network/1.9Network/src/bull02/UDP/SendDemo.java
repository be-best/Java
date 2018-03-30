package bull02.UDP;
/*
 * ʹ��UDPЭ�鷢��Э�飺
 * 	�������Ͷ�Socket����
 * 	�������ݲ����
 * 	��������
 * 	�ͷ���Դ
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class SendDemo {
	public static void main(String[] args) throws IOException {
		//�������Ͷ�Socket����
		DatagramSocket ds = new DatagramSocket();
		
		//�������ݲ����
		/*
		 * DatagramPacket:�����ʾ���ݰ�
		 * ����byte[]
		 * �豸��ַip
		 * ���̵ĵ�ַ�˿ں�
		 */
		//1.����byte[],תΪ�ֽ�
		String str = "hello world";
		byte[] by = str.getBytes();
		int length = by.length;
		//2.�����豸��ip��ַ
		InetAddress address = InetAddress.getByName("DESKTOP-ICVMAGQ");//���͸�ָ���豸
		//3.���̵ĵ�ַ�˿ں�
		int port = 8888;
		//���
		DatagramPacket dp = new DatagramPacket(by, length, address,port);
		
		//��������
		ds.send(dp);
		//�ͷ���Դ
		ds.close();
	}
}
