package myArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest4 {
	public static void main(String[] args) {
		ArrayList<StudentTest4> array = new ArrayList<StudentTest4>();
		addStudent(array);
		addStudent(array);
		addStudent(array);
		
		for(int x=0;x<array.size();x++) {
			StudentTest4 stut = array.get(x);
			System.out.println(stut.getName()+"---"+stut.getAge());
		}
	}
	
	public static void addStudent(ArrayList<StudentTest4> array) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入姓名：");
		String name = sc.nextLine();
		System.out.println("请输入年龄：");
		String age = sc.nextLine();
		
		StudentTest4 stu = new StudentTest4();
		stu.setName(name);
		stu.setAge(age);
		
		array.add(stu);
		
	}
}
