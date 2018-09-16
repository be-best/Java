package bull04.C3P0;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import bull01.JDBCbasis.JDBCUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * C3P0
 * @author 45¶ÈÕ¨
 *
 */
public class C3P0demo1 {
	@Test
	public void demo1() {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//ComboPooledDataSource dataSource = new ComboPooledDataSource("bull");
			//conn = dataSource.getConnection();
			conn = C3P0JDBCUtils.getConnection();
			String sql = "select * from category";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("cid")+"---"+rs.getString("cname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(rs, psmt, conn);
		}
	}
	
	
	
}
