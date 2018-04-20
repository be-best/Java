package bull08.ThreadLocal;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import bull.domain.Product;
import bull.utils.JDBCUtils;

/*
 * 不用传递conn连接,连接保存到ThreadLocal，从工具类中获取连接：C3P0Utils.getConnection()。
 */
public class AccountDao {
	public void out(String outUser ,Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		//sql
		String sql = "update account set money = money + ? where name = ?;";
		//实际参数
		Object[] params = {money,outUser};
		//执行
		queryRunner.update(C3P0Utils.getConnection(), sql, params);
	}
	
	public void in(String inUser ,Double money) throws SQLException {
		QueryRunner queryRunner = new QueryRunner();
		String sql = "update account set money = money - ? where name = ?;";
		Object[] params = {money,inUser};
		queryRunner.update(C3P0Utils.getConnection(), sql, params);
	}
	
	
}
