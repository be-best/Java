package bull02.Ajax.AjaxDao;

import java.sql.SQLException;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import bull.utils.C3P0JDBCUtils;
import bull02.Ajax.domain.User;

public class AjaxDao {
	/**
	 * —∞’“user
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public User findUser(String username) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from user1 where username = ?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class), username);
		return user;
	}

}
