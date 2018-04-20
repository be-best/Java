package bull07.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import bull03.C3P0.C3P0Utils;
import bull07.dao.AccountDao;

public class AccountService {
	public void transfer(String outUser,String inUser,Double money) {	
		Connection conn = null;
		try {
			//获得连接
			conn = C3P0Utils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//业务操作
			AccountDao accountDao = new AccountDao();
			accountDao.out(conn,outUser,money);
			//模拟异常
			//int i = 1/0;
			accountDao.in(conn,inUser, money);
			
			//提交事务并释放资源
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// 事务回滚
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
	}
}
