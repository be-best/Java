package bull05.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0JDBCUtils_1 {
private static final ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
private static final ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	/**
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//先从当前线程直接获取连接
			conn = tl.get();
			//如果当前线程连接为空,从连接池获取
			if(conn == null) {
				conn = dataSource.getConnection();
				//连接池获取后绑定到当前线程
				tl.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 开启事务
	 * @throws SQLException 
	 */
	public static void beginTransaction() throws SQLException {
		Connection conn = null;
		//先从当前线程直接获取连接
		conn = tl.get();
		//如果当前线程连接为空,从连接池获取
		if(conn == null) {
			//连接池获取后绑定到当前线程
			conn = dataSource.getConnection();
			tl.set(conn);
		}
		conn.setAutoCommit(false);
	}
	
	/**
	 * 提交事务
	 * @return
	 * @throws SQLException 
	 */
	public static void commitTransaction() throws SQLException {
		Connection conn = null;
		conn.commit();
	}
	
	/**
	 * 事务回滚
	 * @return
	 * @throws SQLException 
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection conn = null;
		conn.rollback();
	}
	
	/**
	 * 获得数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 释放资源
	 * @param rs
	 * @param psmt
	 * @param conn
	 */
	public static void closeResource(ResultSet rs,PreparedStatement psmt,Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			psmt = null;
		}
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}

}
