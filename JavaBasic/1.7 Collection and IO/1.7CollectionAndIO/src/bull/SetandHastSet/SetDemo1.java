package bull.SetandHastSet;

import java.util.HashSet;

/*
 * 使用HashSet
 * 		不允许重复，会输出false
 * 		无需输出
 * 		无整数索引
 */
public class SetDemo1 {
	public static void main(String[] args) {
		//创建集合对象
		HashSet<String> hs = new HashSet<String>();
		hs.add("hello");
		hs.add("world");
		hs.add("java");
		//不允许重复，会输出false
		System.out.println(hs.add("java"));
		
		for(String s : hs) {
			//无序输出
			System.out.println(s);
		}
	}
}
