package bull01.JDBCbasis;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;
/**
 * 
 * @author 45度炸
 * JDBC给数据库增删改查
 */
public class JDBCTest2 {
	@Test
	public void demo() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs =null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//获得语句执行者
			String sql = "insert into category values (null,?)";
			psmt = conn.prepareStatement(sql);
			//设置参数
			psmt.setString(1, "书包");
			int i = psmt.executeUpdate();
			if(i > 0) {
				System.out.println("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
}
