package bull.SetandHastSet;

import java.util.HashSet;

/*
 * ʹ��HashSet
 * 		�������ظ��������false
 * 		�������
 * 		����������
 */
public class SetDemo1 {
	public static void main(String[] args) {
		//�������϶���
		HashSet<String> hs = new HashSet<String>();
		hs.add("hello");
		hs.add("world");
		hs.add("java");
		//�������ظ��������false
		System.out.println(hs.add("java"));
		
		for(String s : hs) {
			//�������
			System.out.println(s);
		}
	}
}
