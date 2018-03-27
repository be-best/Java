package bull1715.Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/*
 * Properties��IO����ϵĹ��ܣ�
 * 		void load(Reader reader);
 * 		void list(PrintWriter list);ֻ��д��ӡ��
 * 		void store(Writer writer,String comments);����Sring comments�Ƕ��ļ����ݵ�����
 */
public class PropertiesDemo2 {
	public static void main(String[] args) throws IOException {
		//д���ݷ�ʽһ
		method1();
		//������
		method2();
		//д���ݷ�ʽ��
		method3();
	}

	private static void method3() throws IOException {
		//���������б����
		Properties prop = new Properties();
		//�������������
		FileWriter fw = new FileWriter("PD2.txt");
		//���ӳ�����
		prop.setProperty("��һ", "0001");
		prop.setProperty("���", "0002");
		prop.setProperty("����", "0003");
		//void store(Writer writer,String comments);����Sring comments�Ƕ��ļ����ݵ�����
		prop.store(fw, "PropertiesDemo2");
		//�ͷ���Դ
		fw.close();
	}

	private static void method2() throws FileNotFoundException, IOException {
		//���������б����
		Properties prop = new Properties();
		//��������������
		FileReader fr = new FileReader("PD2.txt");
		
		prop.load(fr);
		//�ͷ���Դ
		fr.close();
		System.out.println(prop);
	}

	private static void method1() throws FileNotFoundException {
		//���������б����
		Properties prop = new Properties();
		//������ӡ������
		PrintWriter pw = new PrintWriter("PD2.txt");
		
		prop.setProperty("����", "001");
		prop.setProperty("����", "002");
		prop.setProperty("����", "003");
		//void list(PrintWriter list);
		prop.list(pw);
		//�ͷ���Դ
		pw.close();
	}
}
