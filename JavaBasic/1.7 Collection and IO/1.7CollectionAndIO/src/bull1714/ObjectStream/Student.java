package bull1714.ObjectStream;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * �����ʵ�����л��ӿڳ��ֵĻ�ɫ��������
	 * ��������кź����/ɾ����Ա�����������
	 */
	private static final long serialVersionUID = 844933104622211505L;
	
	String name;
	int age;
	
	public Student() {
		
	}
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	//��дtoString����
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}
