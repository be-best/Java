package bull01.Product.ProductService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import bull.utils.C3P0JDBCUtils;
import bull01.Product.ProductDao.ProductDao;
import bull01.Product.ProductDomain.PageBean;
import bull01.Product.ProductDomain.Product;


public class ProductService {

	/**
	 * 查询所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findAll() throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.findAll();
		return list;
	}

	/**
	 * 添加数据
	 * @param product
	 * @throws SQLException
	 */
	public void add(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.add(product);
	}

	/**
	 * 修改数据
	 * @param product
	 * @throws SQLException 
	 */
	public void update(Product product) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.update(product);
	}

	/**
	 * 利用ID寻找对应的product
	 * @return
	 * @throws SQLException 
	 */
	public Product findById(String id) throws SQLException {
		ProductDao productDao = new ProductDao();
		Product product = productDao.findById(id);
		return product;
	}

	/**
	 * 删除单条数据
	 * @param pid
	 * @throws SQLException
	 */
	public void deleteById(String pid) throws SQLException {
		ProductDao productDao = new ProductDao();
		productDao.deleteById(pid);
	}

	/**
	 * 删除所有数据,采用事务处理方式
	 * @param ids
	 */
	public void deleteAll(String[] ids) {
		Connection conn = null;
		try {
			ProductDao productDao = new ProductDao();
			conn = C3P0JDBCUtils.getConnection();
			conn.setAutoCommit(false);
			for (String id : ids) {
				productDao.deleteAll(conn,id);
			}
			DbUtils.commitAndCloseQuietly(conn);
		} catch (SQLException e) {
			DbUtils.rollbackAndCloseQuietly(conn);
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查找数据
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public List<Product> search(String pname) throws SQLException {
		ProductDao productDao = new ProductDao();
		List<Product> list = productDao.search(pname);
		return list;
	}

	/**
	 * 分页显示
	 * @param currPage
	 * @return
	 * @throws SQLException 
	 */
	public PageBean pageShow(int currPage) throws SQLException {
		/**
		 * 设置PageBean数据
		 */
		ProductDao productDao = new ProductDao();
		PageBean pageBean = new PageBean();
		//设置当前页数
		pageBean.setCurrPage(currPage);
		//每页显示记录数
		int pageSize = 10;
		pageBean.setPageSize(10);
		//设置总记录数
		int totalCount = productDao.findTotalCount();
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % pageSize == 0) {
			totalPage = totalCount/pageSize;
		}
		if(totalCount % pageSize != 0) {
			totalPage = totalCount/pageSize + 1;
		}
		/*
		//把totalCount转为double类型
		double tC = totalCount;
		//向上取整
		Double num = Math.ceil(tC/pageSize);
		//将totalPage转为int型
		totalPage = num.intValue();
		*/
		pageBean.setTotalPage(totalPage);
		//设置每页的数据集合
		int begin = (currPage-1)*pageSize;
		List<Product> list = productDao.findPageProduct(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	

}
