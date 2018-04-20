package bull02.JDBCUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/mydb";
	private static String user = "root";
	private static String password = "root";
	
	//注册驱动
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			//抛去运行时期异常
			throw new RuntimeException(e);
		}
	}
	
	//获得连接
	public static Connection getConnections() throws SQLException {
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	//释放资源
	public static void closeResource(Connection conn,Statement st,ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
			};
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}

