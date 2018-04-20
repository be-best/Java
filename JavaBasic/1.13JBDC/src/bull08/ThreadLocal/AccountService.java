package bull08.ThreadLocal;

import java.sql.Connection;

import org.apache.commons.dbutils.DbUtils;

public class AccountService {
	public void transfer(String outUser ,String inUser ,Double money) {
		Connection conn = null;
		try {
			//获得连接
			conn = C3P0Utils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//业务操作
			AccountDao accountDao = new AccountDao();
			accountDao.out(outUser, money);
			accountDao.in(inUser, money);
			//提交事务
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// 事务回滚
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
	}
}
