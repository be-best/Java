package bull06.transfer_2;
/*
 * ����DBUtils��ʽ
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.jdbc.ResultSet;

public class AccountDao {

	public void outMoney(Connection conn, String from, String to, Double money) throws SQLException {
		//��ҵ����ȡ����,�������ﲻ��new QueryRunner(C3P0JDBCUtils.getDataSource);
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money = money - ? where name = ?";
		queryRunner.update(conn, sql, money,from);
	}

	public void inMoney(Connection conn, String from, String to, Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set monry = money + ? where name = ?";
		queryRunner.update(conn, sql, money,to);
	}
}