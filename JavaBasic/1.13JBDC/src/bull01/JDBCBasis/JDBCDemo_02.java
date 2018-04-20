package bull01.JDBCBasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo_02 {
	@Test
	public void method1()  {
		//1.注册驱动
		//2.获得连接,三个参数url,user,password
		Connection conn = null;
		//3.获得语句执行者
		Statement st = null;
		//4.执行SQL语句
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
			st = conn.createStatement();
			rs = st.executeQuery("select * from category");
			//5.处理结果集
			/*
			 * rs.next()指向下一行。true:有效；false:尾。
			 * rs.previous()指向上一行。true:有效；false:头。
			 */
			while(rs.next()) {
				Integer cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid+"---"+cname);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//6.释放资源
		/*
		 * 后开先关
		 * 从下往上关
		 */
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
