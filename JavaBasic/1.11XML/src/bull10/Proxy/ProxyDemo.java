package bull10.Proxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ProxyDemo {
	@Test
	public void method() {
		List<String> list1 = new ArrayList<String>();
		list1.add("abc");
		String s1 = list1.get(0);
		System.out.println(s1);
		
		
		/*
		 * java.lang.UnsupportedOperationException
		 * 不支持操作异常，当前list2不支持修改，所以不能add.
		 */
		List<String> list2 = MyCollections.unmodifiableList(list1);
		String s2 = list2.get(0);
		System.out.println(s2);
		list2.add("def");
		System.out.println(list2.size());
	}
}
