package bull.userLogin;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * User��Dao��
 * @author 45��ը
 *
 */
public class UserDao {
	//�������ݿ�
	public User login(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user where username = ? and password = ?";
		User existUser = queryRunner.query(sql, new BeanHandler<User>(User.class), user.getUsername(),user.getPassword());
		return existUser;
	}

}
