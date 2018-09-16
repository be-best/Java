package bull.userLogin;

import java.sql.SQLException;

/**
 * Service¿‡
 * @author 45∂»’®
 *
 */
public class UserService {

	public User login(User user) throws SQLException {
		UserDao userDao = new UserDao();
		return userDao.login(user);
	}

}
