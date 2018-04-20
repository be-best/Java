package bull02.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

public class PreparedDemo {
	@Test
	public void method() {
		String name = "jack #";
		String passwd = "123456";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获取SQL语句
			String sql = "select * from user where name = ? and passwd = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setString(1, name);
			psmt.setString(2, passwd);
			//执行
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("登录成功！");
			}
			else {
				System.out.println("登录失败！");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
}
