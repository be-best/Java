package bull1714.ObjectStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * 采用集合解决对象输入流读取对象出现异常的问题
 */
public class ObjectStreamDemo2 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		//用对象输出流写数据
		method1();
		//用对象输入流写数据
		method2();
	}

	private static void method2() throws IOException, FileNotFoundException,
			ClassNotFoundException {
		//创建对象输入流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OSD2.txt"));
		//创建Object对象接收数据，这边读一次o,因为写数据的时候把对象都放进一个集合里，用输出流写出这个集合
		Object o = ois.readObject();
		//向下转型
		ArrayList<Student> arr = (ArrayList<Student>) o;
		for (Student student : arr) {
			System.out.println(student);
		}
		//释放资源
		ois.close();
	}

	private static void method1() throws IOException, FileNotFoundException {
		//创建对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OSD2.txt"));
		//创建集合对象
		ArrayList<Student> arr = new ArrayList<Student>();
		//创建学生对象
		Student stu1 = new Student("张三",10);
		Student stu2 = new Student("李四",11);
		//添加对象到集合中
		arr.add(stu1);
		arr.add(stu2);
		//写出对象
		oos.writeObject(arr);
		//释放资源
		oos.close();
	}
}
