package bull06.Regist;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import bull03.ServletDownload.C3P0JDBCUtils;

public class UserDao {

	public void regist(User user) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into user values (null,?,?,?,?,?,?)";
		Object[] param = {user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getTelephone()};
		queryRunner.update(sql, param);
	}

}
