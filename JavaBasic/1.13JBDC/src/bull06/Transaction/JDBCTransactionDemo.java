package bull06.Transaction;
/*
 * JDBC事务操作
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import bull03.C3P0.C3P0Utils;

public class JDBCTransactionDemo {
	@Test
	public void demo() throws SQLException {
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			//获得连接
			conn = C3P0Utils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//操作
			String sql = "update account set money = money + ? where name = ?";
			psmt = conn.prepareStatement(sql);
			//加钱
			psmt.setInt(1, -100);
			psmt.setString(2, "jack");
			psmt.executeUpdate();
			
			//模拟异常
			//int i = 1/0;//此时报错，事务回滚。因为加钱减钱要都成功才不会出现回滚。
			
			//减钱
			psmt.setInt(1, 100);
			psmt.setString(2, "rose");
			psmt.executeUpdate();
			
			//提交事务
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			throw new RuntimeException("事务回滚",e);
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
