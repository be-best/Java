package bull1714.ObjectStream;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * 使用对象数出流和读对象输入流写数据
 */
public class ObjectStreamDemo1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//使用对象输出流写数据
		method1();
		//使用对象输入流读数据
		method2();
	}

	private static void method2() throws IOException, FileNotFoundException,
			ClassNotFoundException {
		//创建对象输入流
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("OSD1.txt"));
		
		//创建Object对象读数据
		//采用捕获异常方式
		try {
			while(true) {
				Object o = ois.readObject();
				System.out.println(o);
			} 
			}catch(EOFException e) {
				System.out.println("读到了文件的末尾！");
		}
		
		//释放资源
		ois.close();
	}

	private static void method1() throws IOException, FileNotFoundException {
		//创建对象输出流
//		FileOutputStream fos = new FileOutputStream("OSD1.txt");
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("OSD1.txt"));
		
		//创建学生对象
		Student stu1 = new Student("张三",10);
		Student stu2 = new Student("李四",11);
		
		//写出学生对象
		oos.writeObject(stu1);
		oos.writeObject(stu2);
		
		//释放资源
		oos.close();
	}
}
