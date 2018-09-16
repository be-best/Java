package bull01.Product.ProductDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import bull.utils.C3P0JDBCUtils;
import bull01.Product.ProductDomain.Product;

public class ProductDao {

	public List<Product> findAll() throws SQLException {
		/**
		 * 查询所有数据
		 */
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product order by pdate desc";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class));
		return list;
	}

	/**
	 * 添加数据
	 * @param product
	 * @throws SQLException
	 */
	public void add(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {product.getPid(),product.getPname(),product.getMarket_price(),
				product.getShop_price(),product.getPimage(),product.getPdate(),product.getIs_hot(),
				product.getPdesc(),product.getPflag(),product.getCid()};
		queryRunner.update(sql, params);
	}

	/**
	 * 修改数据
	 * @param product
	 * @throws SQLException 
	 */
	public void update(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update product set pname =?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid=? ";
		Object[] params = { product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(), product.getPdate(), product.getIs_hot(), product.getPdesc(), product.getPflag(),
				product.getCid(),product.getPid()};
		queryRunner.update(sql, params);
	}

	/**
	 * 利用Id寻找对应的product
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public Product findById(String id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pid = ?";
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class), id);
		return product;
	}

	/**
	 * 删除一条数据
	 * @param pid
	 * @throws SQLException 
	 */
	public void deleteById(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "delete from product where pid = ?";
		queryRunner.update(sql, pid);
	}

	/**
	 * 删除所有数据
	 * @param conn
	 * @param id
	 * @throws SQLException 
	 */
	public void deleteAll(Connection conn, String id) throws SQLException {
		//不用获取连接，业务层已获取
		QueryRunner queryRunner = new QueryRunner();
		String sql = "delete from product where pid = ?";
		queryRunner.update(conn, sql, id);
	}

	/**
	 * 查询数据
	 * @param pname
	 * @return
	 * @throws SQLException 
	 */
	public List<Product> search(String pname) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pname like ? order by pdate desc";
		//"%"+pname+"%" --> %pname%
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), "%"+pname+"%");
		return list;
	
	}

	/**
	 * 查询总记录数
	 * @return
	 * @throws SQLException 
	 */
	public int findTotalCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from product";
		Long totalCount = queryRunner.query(sql, new ScalarHandler()); 	
		return totalCount.intValue();
	}
	
	/**
	 * 查询每页的数据
	 * @param begin
	 * @param pageSize
	 * @return
	 * @throws SQLException
	 */
	public List<Product> findPageProduct(int begin, int pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), begin,pageSize);
		return list;
	}

}
