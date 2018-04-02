package bull04.Method;

import java.util.Arrays;

/*
 * JavaBean�淶
 * 1.�ṩ˽���ֶΣ����磺private String id;
 * 2.�����ṩgetter��setter����
 * 3.�ṩ�޲ι��췽��
 * 4.����ʵ�����л��ӿ�:
 * 			java.io.Serializable
 */
public class Bean implements java.io.Serializable {
	private String name;
	private int age;
	public String sex;
	
	public Bean() {
		System.out.println("������Bean���޲ι��죡");
	}
	
	public Bean(String name,int age) {
		System.out.println("������Bean���вι��죡");
		this.name = name;
		this.age = age;
	}
	
	private Bean(String name) {
		this.name = name;
		this.age = age;
	}
	
	public static void main(String[] args) {
		//��ָ��������ת�����ַ���
		System.out.println(Arrays.toString(args));
	}

	private void show(int num) {
		System.out.println("˽�з�����"+num);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	//��дtoString����
	@Override
	public String toString() {
		return "Bean [name=" + name + ", age=" + age + "]";
	}
	
	
}
