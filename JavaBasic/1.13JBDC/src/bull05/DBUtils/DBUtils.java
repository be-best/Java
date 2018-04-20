package bull05.DBUtils;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

/*
 * QueryRunner实现添加、更新、删除操作
 */
public class DBUtils {
	@Test
	public void demo1() throws SQLException {
		//添加
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.SQL语句
		String sql = "insert into product (pid,pname,price,category_id) values (?,?,?,?);";
		//3.实际参数
		Object[] parms = {14,"耐克",999,"c002"};
		//4.执行
		int r = queryRunner.update(sql,parms);
		
		System.out.println(r);
	}
	
	@Test
	public void demo2() throws SQLException {
		//修改
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "update product set pname = ?,price = ?,category_id = ? where pid = ?;";
		//3.实际参数
		Object[] parms = {"阿迪达斯",666,"c002",11};
		//4.执行
		int r = queryRunner.update(sql, parms);
		System.out.println(r);
	}
	
	@Test
	public void demo3() throws SQLException {
		//删除
		//1.核心类
		QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
		//2.sql语句
		String sql = "delete from product where pid = ?";
		//3.实际参数
		Object[] parms = {14};
		//4.执行
		int r = queryRunner.update(sql, parms);
		System.out.println(r);
	}
}
