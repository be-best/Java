package bull01.MyBeanUtils;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import bull01.BeanUtils.User;

public class TestTool {
	@Test
	public void method() {
		Map<String,String[]> map = new HashMap();
		map.put("userName", new String[]{"kobe"});
		map.put("userId", new String[]{"Id002"});
		map.put("userPasswd", new String[]{"9246538"});
		map.put("userHobby", new String[]{"������","������"});
		map.put("userAge", new String[]{"10"});
		/*
		 * ���ݵĲ���һ���������һ����Map����
		 */
		User user = MyBeanUtilsDemo_01.populate(User.class,map);
		System.out.println(user);
	}
}
