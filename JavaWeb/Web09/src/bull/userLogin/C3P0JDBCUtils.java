package bull.userLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0JDBCUtils {
	private static final ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
	
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
