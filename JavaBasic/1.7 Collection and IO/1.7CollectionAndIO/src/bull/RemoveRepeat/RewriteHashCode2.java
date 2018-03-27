package bull.RemoveRepeat;

import java.util.HashSet;

/*
 * ��дequals��hashCode����
 */
public class RewriteHashCode2 {
	public static void main(String[] args) {
		//�������϶���
		HashSet<Person> hs = new HashSet<Person>();
		//����Person����
		Person p1 = new Person("����",10);
		Person p2 = new Person("����",11);
		Person p3 = new Person("����",11);
		//��Ӽ���Ԫ��
		hs.add(p1);
		hs.add(p2);
		hs.add(p3);
		//��������
		for (Person person : hs) {
			System.out.println(person);
		}
	}
}

class Person {
	String name;
	int age;
	
	public Person() {
		
	}
	
	public Person(String name,int age) {
		this.name = name;
		this.age = age;
	}
	//��дtoString����
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	//��дhashCode����
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result= result+age
		result = prime*1 + result;
		//result=result+name.hashCode()
		//name=null����0�����򷵻�name.hashCode().
		result = prime*result + ((name == null)?0 : name.hashCode());
		return result;
	}
	//��дequals����
	public boolean equals(Object obj) {
		//���Ч��
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		//��ߴ��뽡׳��,����ͬһ�����;�ֱ�ӷ���false,ʡ������ת����
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		//����ת��
		Person p = (Person)obj;
		if(this.age != p.age) {
			return false;
		}
		if(this.name == null) {
			if(p.name != null) {
				return false;
			}
			
		}
		else if(!this.name.equals(p.name)) {
			return false;
		}
		return true;
	}
	
}