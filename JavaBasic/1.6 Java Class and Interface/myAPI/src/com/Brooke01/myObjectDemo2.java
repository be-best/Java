package com.Brooke01;
/*
 * boolean equals(Object obj)
 * ��дequals����
 */
public class myObjectDemo2 {
	public static void main(String[] args) {
		Students stu1 = new Students("����",11);
		Students stu2 = new Students("����",11);
		boolean flag = stu1.equals(stu2);
		System.out.println(flag);
	}
}

class Students {
	String name;
	int age;
	
	public Students(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	//��дequals����
	public boolean equals(Object obj) {
		//���Ч��
		//�Ƚϵ�ֵַ�Ƿ�һ��
		if(this == obj) {
			return true;
		}
		//�жϵ�ֵַ�Ƿ�Ϊ��
		if(obj == null) {
			return false;
		}
		//��ߴ��뽡׳��
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		//����ת��
		Students stu = (Students) obj;
		//�ж�����
		if(age != stu.age) {
			return false;
		}
		if(name == null) {
			//�ж������Ƿ�Ϊ��
			if(this.name == null) {
				return true;
			}
			else {
				//�ж������Ƿ���ͬ��ͬ
				if(!name.equals(stu.name)) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
