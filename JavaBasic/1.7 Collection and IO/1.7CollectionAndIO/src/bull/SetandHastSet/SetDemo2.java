package bull.SetandHastSet;

import java.util.HashSet;

/*
 * 使用HashSet存储自定义对象并遍历:
 * 		HashSet的add()方法，首先使用集合中的每一个元素和要添加的元素的hash值进行比较
 * 			如果hash值不一样，则直接添加元素
 * 			如果hash值一样，比较地址值或者使用equals方法进行比较
 * 			比较结果一样，则认为是重复不添加
 * 			所有的比较结果都不一样，则添加
 * 			
 */
public class SetDemo2 {
	public static void main(String[] args) {
		//创建集合对象
		HashSet<Student> hs = new HashSet<Student>();
		//创建学生对象
		Student stu1 = new Student("张三",10);
		Student stu2 = new Student("李四",11);
		Student stu3 = new Student("李四",11);
		//添加学生对象到集合中,stu2与stu3的地还不一样，hash值不一样，不会重复.
		hs.add(stu1);
		hs.add(stu2);
		hs.add(stu3);
		//遍历集合
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

	//重写toString方法，不然输出的是地址值
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}