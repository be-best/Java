package myArrayList;

import java.util.ArrayList;

public class ArrayListTest3 {
	public static void main(String[] args) {
		//创建集合对象,注意<StudentTest3>;
		ArrayList<StudentTest3> array = new ArrayList<StudentTest3>();
		
		StudentTest3 stu1 = new StudentTest3("张三",10);
		StudentTest3 stu2 = new StudentTest3("李四",9);
		StudentTest3 stu3 = new StudentTest3("王五",8);
		StudentTest3 stu4 = new StudentTest3("赵六",7);
		
		array.add(stu1);
		array.add(stu2);
		array.add(stu3);
		array.add(stu4);
		
		for(int x=0;x<array.size();x++) {
			StudentTest3 stu = array.get(x);
			System.out.println(stu);//输出地址
			System.out.println(stu.getName()+"---"+stu.getAge());
		}
		
	}
}
