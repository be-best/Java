package bull01.JDBCBasis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo_01 {
	@Test
	public void method1() throws Exception {
		Connection conn = JDBCUtils.getConnections();
		//1.注册驱动
		//Class.forName("com.mysql.jdbc.Driver");
		//2.获得连接,三个参数url,user,password
		//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
		//3.获得语句执行者
		Statement st = conn.createStatement();
		//4.执行SQL语句
		ResultSet rs = st.executeQuery("select * from category");
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
		//6.释放资源
		/*
		 * 后开先关
		 * 从下往上关
		 */
		rs.close();
		st.close();
		conn.close();
	}
}
