package autologin.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import autologin.domain.User;
import autologin.utils.C3P0JDBCUtils;

public class UserDao {

	public User userLogin(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		return existUser;
	}

}
