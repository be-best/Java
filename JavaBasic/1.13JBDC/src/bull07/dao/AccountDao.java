package bull07.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class AccountDao {
	public void out(Connection conn ,String outUser, Double money) throws SQLException {
		//获得连接
		//传进了conn，所以不用提供数据源。
		QueryRunner queryRunner = new QueryRunner();
		//SQL语句
		String sql = "update account set money = money + ? where name = ?;";
		//实际参数
		Object[] param = {money,outUser};
		//执行
		queryRunner.update(conn,sql, param);
	}
	
	public void in(Connection conn ,String inUser, Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money = money - ? where name = ?;";
		Object[] param = {money,inUser};
		queryRunner.update(conn,sql, param);
	}
}
