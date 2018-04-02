package bull03.Constructor;
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
	
	
}
