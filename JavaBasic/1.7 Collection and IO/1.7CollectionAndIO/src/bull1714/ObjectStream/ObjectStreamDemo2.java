package bull1714.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * ���ü��Ͻ��������������ȡ��������쳣������
 */
public class ObjectStreamDemo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//�ö��������д����
		method1();
		//�ö���������д����
		method2();
	}

	private static void method2() throws IOException, FileNotFoundException,
			ClassNotFoundException {
		//��������������
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OSD2.txt"));
		//����Object����������ݣ���߶�һ��o,��Ϊд���ݵ�ʱ��Ѷ��󶼷Ž�һ��������������д���������
		Object o = ois.readObject();
		//����ת��
		ArrayList<Student> arr = (ArrayList<Student>) o;
		for (Student student : arr) {
			System.out.println(student);
		}
		//�ͷ���Դ
		ois.close();
	}

	private static void method1() throws IOException, FileNotFoundException {
		//�������������
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OSD2.txt"));
		//�������϶���
		ArrayList<Student> arr = new ArrayList<Student>();
		//����ѧ������
		Student stu1 = new Student("����",10);
		Student stu2 = new Student("����",11);
		//��Ӷ��󵽼�����
		arr.add(stu1);
		arr.add(stu2);
		//д������
		oos.writeObject(arr);
		//�ͷ���Դ
		oos.close();
	}
}
