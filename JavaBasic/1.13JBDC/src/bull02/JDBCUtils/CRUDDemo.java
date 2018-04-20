package bull02.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/*
 * 数据库增删改查
 */
public class CRUDDemo {
	@Test
	public void demo1() {
		//添加
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得语句执行者
			st = conn.createStatement();
			//执行SQL语句
			int r = st.executeUpdate("insert into category (cname) values ('测试')");
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
			
		} finally {
			JDBCUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo2() {
		//删除
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得语句执行者
			st = conn.createStatement();
			//执行SQL语句
			int r = st.executeUpdate("delete from category where cid = 7");
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo3() {
		//修改
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得语句执行者
			st = conn.createStatement();
			//执行SQL语句
			int r = st.executeUpdate("update category set cname = '食品' where cid = 3");
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, st, rs);
		}
	}
	
	@Test
	public void demo4() {
		//查询
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得语句执行者
			st = conn.createStatement();
			//执行SQL语句
			rs = st.executeQuery("select * from category");
			
			while(rs.next()) {
				int cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid + "---" + cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
