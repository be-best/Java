package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * 采用HashMap遍历自定义对象，同时要实现去重
 */
public class HashMapDemo2 {
	public static void main(String[] args) {
		//创建HashMap对象
		HashMap<Student,String> hm = new HashMap<Student,String>();
		//创建学生对象
		//可通过重写hashCode()和equals()方法实现去重
		Student stu1 = new Student("张三",10);
		Student stu2 = new Student("张三",10);
		Student stu3 = new Student("李四",11);
		
		hm.put(stu1, "H001");
		hm.put(stu2, "H002");
		hm.put(stu3, "H003");
		
		//遍历方式一
		Set<Student> stu = hm.keySet();
		for (Student student : stu) {
			String num = hm.get(student);
			System.out.println(student+num);
		}
		System.out.println("----------------------------");
		//遍历方式二
		Set<Map.Entry<Student, String>> entrys = hm.entrySet();
		for (Map.Entry<Student, String> entry : entrys) {
			Student stude = entry.getKey();
			String num = entry.getValue();
			System.out.println(stude+num);
		}
	}
}
