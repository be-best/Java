package autologin.service;

import java.sql.SQLException;

import autologin.dao.UserDao;
import autologin.domain.User;

public class UserService {

	public User userLogin(User user) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.userLogin(user);
	}

}
