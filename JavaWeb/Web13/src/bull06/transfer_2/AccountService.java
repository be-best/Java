package bull06.transfer_2;
/*
 * 业务层进行事务操作
 */
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import bull05.Utils.C3P0JDBCUtils;

public class AccountService {

	public void transfer(String from, String to, Double money) {
		AccountDao accountDao = new AccountDao();
		Connection conn = null;
		try {
			conn = C3P0JDBCUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			accountDao.outMoney(conn,from,to,money);
			
			//模拟异常
			//int i = 1/0;
			
			accountDao.inMoney(conn,from,to,money);
			//提交事务
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			try {
				//有异常则回滚
				DbUtils.rollbackAndCloseQuietly(conn);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				//关闭conn连接
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
