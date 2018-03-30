package bull04.UserLogin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * �ͻ���
 */
public class ClientDemo {
	public static void main(String[] args) throws UnknownHostException, IOException {
		//1.�����ͻ���Socket����
		Socket s = new Socket(InetAddress.getByName("DESKTOP-ICVMAGQ"),4738);
		//2.��ȡ�û�������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�������û�����");
		String userName = br.readLine();
		System.out.println("���������룺");
		String userPasswd = br.readLine();
		
		//3.��ȡ���������,���ô�ӡ��(Ҳ������BufferedWriter)����ӡ�����Խ��ֽ������(s.getOutputStream())ת��Ϊ�ַ������
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		
		//4.��������
		pw.println(userName);
		pw.println(userPasswd);
		
		//5.��������
		//��ȡ����������,����ת����InputStreamReader���ֽ���ת��Ϊ�ַ���
		BufferedReader serverBr = new BufferedReader(new InputStreamReader(s.getInputStream()));
		String result = serverBr.readLine();
		System.out.println(result);
		
		//6.�ͷ���Դ
		s.close();
		br.close();
		serverBr.close();
	}
}
