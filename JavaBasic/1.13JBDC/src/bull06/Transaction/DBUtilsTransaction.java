package bull06.Transaction;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import bull03.C3P0.C3P0Utils;

/*
 * DBUtils事务操作
 */
public class DBUtilsTransaction {
	@Test
	public void demo() {
		Connection conn = null;
		//不用给数据源，conn获得连接。
		//QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		QueryRunner queryRunner = new QueryRunner();
		try {
			//获得连接
			conn = C3P0Utils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//操作
			String sql = "update account set money = money + ? where name = ?;";
			int i = queryRunner.update(conn, sql, 100,"jack");
			int j = queryRunner.update(conn, sql, -100,"rose");
			//提交事务并释放资源
			DbUtils.commitAndCloseQuietly(conn);
			System.out.println("提交成功！");
		} catch (Exception e) {
			e.printStackTrace();//可以输出异常。
			//事务回滚
			DbUtils.rollbackAndCloseQuietly(conn);
		}
	}
}
