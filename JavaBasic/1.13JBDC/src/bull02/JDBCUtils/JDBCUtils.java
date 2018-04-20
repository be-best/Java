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
	
	//ע������
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			//��ȥ����ʱ���쳣
			throw new RuntimeException(e);
		}
	}
	
	//�������
	public static Connection getConnections() throws SQLException {
		Connection conn = DriverManager.getConnection(url,user,password);
		return conn;
	}
	
	//�ͷ���Դ
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

