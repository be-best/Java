package myArrayList;

import java.util.ArrayList;

public class ArrayListTest3 {
	public static void main(String[] args) {
		//�������϶���,ע��<StudentTest3>;
		ArrayList<StudentTest3> array = new ArrayList<StudentTest3>();
		
		StudentTest3 stu1 = new StudentTest3("����",10);
		StudentTest3 stu2 = new StudentTest3("����",9);
		StudentTest3 stu3 = new StudentTest3("����",8);
		StudentTest3 stu4 = new StudentTest3("����",7);
		
		array.add(stu1);
		array.add(stu2);
		array.add(stu3);
		array.add(stu4);
		
		for(int x=0;x<array.size();x++) {
			StudentTest3 stu = array.get(x);
			System.out.println(stu);//�����ַ
			System.out.println(stu.getName()+"---"+stu.getAge());
		}
		
	}
}
