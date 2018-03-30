package bull04.UserLogin;

import java.util.ArrayList;
import java.util.List;

/*
 * 用户数据库
 */
public class UserDB {
	private static List<User> user = new ArrayList<User>();
	
	//静态代码块，类加载的时候加载。
	static {
		//添加用户对象到集合之中
		user.add(new User("aaa","bbb"));
		user.add(new User("bbb","ccc"));
		user.add(new User("ccc","ddd"));
		user.add(new User("ddd","eee"));
		user.add(new User("eee","fff"));
		user.add(new User("fff","ggg"));
	}
	
	//用于外部获取user集合
	public static List<User> getUser() {
		return user;
	}
}
