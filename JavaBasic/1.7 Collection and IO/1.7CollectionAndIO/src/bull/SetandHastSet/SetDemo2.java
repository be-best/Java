package bull.SetandHastSet;

import java.util.HashSet;

/*
 * ʹ��HashSet�洢�Զ�����󲢱���:
 * 		HashSet��add()����������ʹ�ü����е�ÿһ��Ԫ�غ�Ҫ��ӵ�Ԫ�ص�hashֵ���бȽ�
 * 			���hashֵ��һ������ֱ�����Ԫ��
 * 			���hashֵһ�����Ƚϵ�ֵַ����ʹ��equals�������бȽ�
 * 			�ȽϽ��һ��������Ϊ���ظ������
 * 			���еıȽϽ������һ���������
 * 			
 */
public class SetDemo2 {
	public static void main(String[] args) {
		//�������϶���
		HashSet<Student> hs = new HashSet<Student>();
		//����ѧ������
		Student stu1 = new Student("����",10);
		Student stu2 = new Student("����",11);
		Student stu3 = new Student("����",11);
		//���ѧ�����󵽼�����,stu2��stu3�ĵػ���һ����hashֵ��һ���������ظ�.
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		//��������
		for (Student student : hs) {
			System.out.println(student);
		}
	}
}

class Student {
	String name;
	int age;
	
	public Student() {
		
	}
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}

	//��дtoString��������Ȼ������ǵ�ֵַ
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}