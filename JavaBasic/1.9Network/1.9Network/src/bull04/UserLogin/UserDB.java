package bull04.UserLogin;

import java.util.ArrayList;
import java.util.List;

/*
 * �û����ݿ�
 */
public class UserDB {
	private static List<User> user = new ArrayList<User>();
	
	//��̬����飬����ص�ʱ����ء�
	static {
		//����û����󵽼���֮��
		user.add(new User("aaa","bbb"));
		user.add(new User("bbb","ccc"));
		user.add(new User("ccc","ddd"));
		user.add(new User("ddd","eee"));
		user.add(new User("eee","fff"));
		user.add(new User("fff","ggg"));
	}
	
	//�����ⲿ��ȡuser����
	public static List<User> getUser() {
		return user;
	}
}
