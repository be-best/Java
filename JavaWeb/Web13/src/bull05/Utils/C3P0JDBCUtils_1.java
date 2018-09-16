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
	 * �������
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//�ȴӵ�ǰ�߳�ֱ�ӻ�ȡ����
			conn = tl.get();
			//�����ǰ�߳�����Ϊ��,�����ӳػ�ȡ
			if(conn == null) {
				conn = dataSource.getConnection();
				//���ӳػ�ȡ��󶨵���ǰ�߳�
				tl.set(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * ��������
	 * @throws SQLException 
	 */
	public static void beginTransaction() throws SQLException {
		Connection conn = null;
		//�ȴӵ�ǰ�߳�ֱ�ӻ�ȡ����
		conn = tl.get();
		//�����ǰ�߳�����Ϊ��,�����ӳػ�ȡ
		if(conn == null) {
			//���ӳػ�ȡ��󶨵���ǰ�߳�
			conn = dataSource.getConnection();
			tl.set(conn);
		}
		conn.setAutoCommit(false);
	}
	
	/**
	 * �ύ����
	 * @return
	 * @throws SQLException 
	 */
	public static void commitTransaction() throws SQLException {
		Connection conn = null;
		conn.commit();
	}
	
	/**
	 * ����ع�
	 * @return
	 * @throws SQLException 
	 */
	public static void rollbackTransaction() throws SQLException {
		Connection conn = null;
		conn.rollback();
	}
	
	/**
	 * �������Դ
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * �ͷ���Դ
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
