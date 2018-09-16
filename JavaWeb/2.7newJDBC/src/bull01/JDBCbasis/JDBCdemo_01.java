package bull01.JDBCbasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * 
 * @author 45度炸
 *
 */
public class JDBCdemo_01 {
	@Test
	public void demo() {
		//注册驱动
		//获得连接
		Connection conn = null;
		//conn连接获得SQL语句执行者psmt
		PreparedStatement psmt = null;
		//执行psmt获得结果集rs
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			String sql = "select * from category";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			//处理结果集
			while(rs.next()) {
				System.out.println(rs.getInt("cid")+"---"+rs.getString("cname"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(psmt != null) {
				try {
					psmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
