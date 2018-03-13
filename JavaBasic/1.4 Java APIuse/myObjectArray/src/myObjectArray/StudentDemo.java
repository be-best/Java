package myObjectArray;

public class StudentDemo {
	public static void main(String[] args) {
		//创建学生数组
		Student[] stu = new Student[3];
		
		//创建对象
		Student stu1 = new Student("张一",33);
		Student stu2 = new Student("王二",32);
		Student stu3 = new Student("刘三",31);
		
		//给对象数组赋值
		stu[0] = stu1;
		stu[1] = stu2;
		stu[2] = stu3;
		
		//遍历数组
		for(int x=0;x<stu.length;x++) {
			System.out.println(stu[x]);
			System.out.println(stu[x].getName()+"---"+stu[x].getAge());
		}
	}
}
