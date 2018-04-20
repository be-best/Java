package bull.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import bull.ProductDao.ProductDao;
import bull.domain.Product;
import bull.utils.JDBCUtils;

/*
 * 
 */
public class ProductService {
	private static final int Integer = 0;
	private static final int List = 0;
	private ProductDao productDao = new ProductDao();
	
	

	public void add(Product product) throws SQLException {
		//添加
		productDao.add(product);
	}

	
	public Product findById(Integer pid) throws SQLException {
		// 查询
		return productDao.findById(pid);
	}
	


	public void edit(Product product) throws SQLException {
		// 修改
		productDao.edit(product);
		
	}


	public List findAll() throws SQLException {
		// 查询所有
		return productDao.findAll();
		
	}


	public void delete(Integer pid) {
		// 删除,采用事务操作方式
		Connection conn = null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//事务操作
			productDao.delete(pid);
			//提交事务
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// 事务回滚
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
		
	}


	public void deleteAll(List<Integer> list) {
		// 批量删除记录，采用事务操作方式
		Connection conn = null;
		try {
			//获得连接
			conn = JDBCUtils.getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//事务操作
			//这边循环删除记录
			for (Integer pid : list) {
				productDao.deleteAll(pid);
			}
			//提交事务
			DbUtils.commitAndCloseQuietly(conn);
		} catch (Exception e) {
			// 事务回滚
			DbUtils.rollbackAndCloseQuietly(conn);
			throw new RuntimeException(e);
		}
		
	}
}










