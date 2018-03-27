package bull.RemoveRepeat;


import java.util.HashSet;

/*
 * 使用HashSet存储自定义对象并遍历:
 * 重写hashCode与equals实现去重
 * 			
 */
public class RewriteHashCode {
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

	
	//重写hashCode方法和
	@Override
	public int hashCode() {
		return 1;
	}
	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		//向下转型
		Student stu = (Student)obj;
		if(this.age != stu.age) {
			return false;
		}
		if(!this.name.equals(stu.name)) {
			return false;
		}
		return true;
	}
	
	
}