package bull06.Regist;

import java.sql.SQLException;

public class UserService {

	public void regist(User user) throws SQLException {
		UserDao userDao = new UserDao();
		userDao.regist(user);
		
	}

}
