package bull.MapAndHashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * ����HashMap�����Զ������ͬʱҪʵ��ȥ��
 */
public class HashMapDemo2 {
	public static void main(String[] args) {
		//����HashMap����
		HashMap<Student,String> hm = new HashMap<Student,String>();
		//����ѧ������
		//��ͨ����дhashCode()��equals()����ʵ��ȥ��
		Student stu1 = new Student("����",10);
		Student stu2 = new Student("����",10);
		Student stu3 = new Student("����",11);
		
		hm.put(stu1, "H001");
		hm.put(stu2, "H002");
		hm.put(stu3, "H003");
		
		//������ʽһ
		Set<Student> stu = hm.keySet();
		for (Student student : stu) {
			String num = hm.get(student);
			System.out.println(student+num);
		}
		System.out.println("----------------------------");
		//������ʽ��
		Set<Map.Entry<Student, String>> entrys = hm.entrySet();
		for (Map.Entry<Student, String> entry : entrys) {
			Student stude = entry.getKey();
			String num = entry.getValue();
			System.out.println(stude+num);
		}
	}
}
