package myObjectArray;

public class StudentDemo {
	public static void main(String[] args) {
		//����ѧ������
		Student[] stu = new Student[3];
		
		//��������
		Student stu1 = new Student("��һ",33);
		Student stu2 = new Student("����",32);
		Student stu3 = new Student("����",31);
		
		//���������鸳ֵ
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
		
		//��������
		for(int x=0;x<stu.length;x++) {
			System.out.println(stu[x]);
			System.out.println(stu[x].getName()+"---"+stu[x].getAge());
		}
	}
}
