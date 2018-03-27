package bull1714.ObjectStream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * ʹ�ö����������Ͷ�����������д����
 */
public class ObjectStreamDemo1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//ʹ�ö��������д����
		method1();
		//ʹ�ö���������������
		method2();
	}

	private static void method2() throws IOException, FileNotFoundException,
			ClassNotFoundException {
		//��������������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OSD1.txt"));
		
		//����Object���������
		//���ò����쳣��ʽ
		try {
			while(true) {
				Object o = ois.readObject();
				System.out.println(o);
			} 
			}catch(EOFException e) {
				System.out.println("�������ļ���ĩβ��");
		}
		
		//�ͷ���Դ
		ois.close();
	}

	private static void method1() throws IOException, FileNotFoundException {
		//�������������
//		FileOutputStream fos = new FileOutputStream("OSD1.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OSD1.txt"));
		
		//����ѧ������
		Student stu1 = new Student("����",10);
		Student stu2 = new Student("����",11);
		
		//д��ѧ������
		oos.writeObject(stu1);
		oos.writeObject(stu2);
		
		//�ͷ���Դ
		oos.close();
	}
}
