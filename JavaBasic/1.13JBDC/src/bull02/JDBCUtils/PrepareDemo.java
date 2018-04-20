package bull02.JDBCUtils;
/*
 * 防SQL注入问题
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class PrepareDemo {
	@Test
	public void demo1() {
		//添加
		Connection conn = null;
		PreparedStatement psmt = null;
	    ResultSet rs = null;
	    
	    try {
			//获得连接
	    	conn = JDBCUtils.getConnections();
	    	//处理SQL语句
	    	String sql = "insert into category (cid,cname) values (?,?)";
	    	//获得预处理对象
	    	psmt = conn.prepareStatement(sql);
	    	//设置实际参数
	    	psmt.setInt(1, 4);
	    	psmt.setString(2, "书本");
	    	//执行，返回的r是数据库改变的行数
	    	int r = psmt.executeUpdate();
	    	System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test 
	public void demo2() {
		//删除
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获取sql语句
			String sql = "delete from category where cid = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setInt(1, 8);
			//执行
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo3() {
		//修改
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得SQL语句
			String sql = "update category set cname = ? where cid = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setString(1, "汽车");
			psmt.setInt(2, 4);
			//执行
			int r = psmt.executeUpdate();
			System.out.println(r);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			//释放资源
			JDBCUtils.closeResource(conn, psmt, rs);
		}
		
	}
	
	@Test
	public void demo4() {
		//全部查询
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得SQL语句
			String sql = "select * from category";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设计实际参数，这里没有参数可以设置
			
			//执行
			rs = psmt.executeQuery();
			while(rs.next()) {
				Integer cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid + "---" + cname);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
	
	@Test
	public void demo5() {
		//通过id查询
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		try {
			//获得连接
			conn = JDBCUtils.getConnections();
			//获得SQL语句
			String sql = "select * from category where cid = ?";
			//获得预处理对象
			psmt = conn.prepareStatement(sql);
			//设置实际参数
			psmt.setInt(1, 1);
			//执行
			rs = psmt.executeQuery();
			if(rs.next()) {
				Integer cid = rs.getInt("cid");
				String cname = rs.getString("cname");
				System.out.println(cid + "---" + cname);
			}
			else {
				System.out.println("查询不到");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JDBCUtils.closeResource(conn, psmt, rs);
		}
	}
}
