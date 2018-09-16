package com.store.dao.imple;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.store.dao.ProductDao;
import com.store.domain.Product;
import com.store.utils.C3P0JDBCUtils;

public class ProductDaoImple implements ProductDao {

	/**
	 * 查询热门推荐商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByHot() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag=? and is_hot=? order by pdate desc limit ?";
		List<Product> hotList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0,1,12);
		return hotList;
	}

	/**
	 * 查询最新商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByNew() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag=? order by pdate desc limit ?";
		List<Product> newList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0,12);
		return newList;
	}

	/**
	 * 根据cid查找分类里的商品总个数
	 * @throws SQLException 
	 */
	@Override
	public Integer findByCid(String cid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from product where cid = ? and pflag = ?";
		Long count = (Long) queryRunner.query(sql, new ScalarHandler(), cid,0);
		return count.intValue();
	}

	@Override
	public List<Product> findPageByCid(String cid, int begin, Integer pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? and cid = ? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class), 0,cid,begin,pageSize);
		return list;
	}

	/**
	 * 根据pid查找商品
	 * @throws SQLException 
	 */
	@Override
	public Product findByPid(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pid = ?";
		Product product = queryRunner.query(sql, new BeanHandler<Product>(Product.class),pid);
		return product;
	}

	/**
	 * 搜索框模糊查询
	 * @throws SQLException 
	 */
	@Override
	public List<Product> searchProduct(String productKeywords,int begin,Integer pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? and pname like ? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class) ,0,productKeywords,begin,pageSize );
		return list;
	}
	/*@Override
	public List<Product> searchProduct(String productKeywords,int begin,Integer pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		char[] keywords = productKeywords.toCharArray();
		List<Product> list = new ArrayList<Product>();
		for(int i = 0;i < keywords.length;i++) {		
			String sql = "select * from product where pflag = ? and pname like ? order by pdate desc limit ?,?";
			List<Product> newList = queryRunner.query(sql, new BeanListHandler<Product>(Product.class) ,0,"%"+keywords[i]+"%",begin,pageSize );
			for (Product product : newList) {
				if(!list.contains(product)) {
					list.add(product);
				}
			}
		}
		return list;
	}*/

	/**
	 * 模糊查询商品个数
	 * @throws SQLException 
	 */
	@Override
	public Integer searchCount(String productKeywords) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from product where pflag = ? and pname like ?";
		Long count =  (Long) queryRunner.query(sql, new ScalarHandler(), 0,"%"+productKeywords+"%");
		return count.intValue();
	}

	/**
	 * 后台查询所有商品个数
	 * @throws SQLException 
	 */
	@Override
	public Integer findByCount() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from product where pflag = ?";
		Long count = (Long) queryRunner.query(sql,new ScalarHandler(),0);
		return count.intValue();
	}

	/**
	 * 后台分页查询商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByPage(int begin, Integer pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class) ,0,begin,pageSize );
		return list;
	}

	/**
	 * 后台添加商品product
	 * @throws SQLException 
	 */
	@Override
	public void addProduct(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?)";
		Object[] params = {product.getPid(),product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),
				new Date(),//product.getPdate()数据库设置的是date日期类型,实体里是String
				product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid()};
		queryRunner.update(sql, params);
		
	}

	/**
	 * 下架商品
	 * @throws SQLException 
	 */
	@Override
	public void pushDown(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update product set pname = ?,market_price=?,shop_price=?,pimage=?,is_hot=?,pdesc= ?,pflag=? where pid = ?";
		Object[] params = { product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(),product.getIs_hot(), product.getPdesc(), product.getPflag(),product.getPid()
				 };
		queryRunner.update(sql, params);
		
	}

	/**
	 * 查询下架商品个数
	 * @throws SQLException 
	 */
	@Override
	public Integer findCountByPushDown() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from product where pflag = ?";
		Long count = (Long) queryRunner.query(sql,new ScalarHandler(),1);
		return count.intValue();
	}

	/**
	 * 后台分页查询下架商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findPageByPushDown(int begin, Integer pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class) ,1,begin,pageSize );
		return list;
	}

	/**
	 * 后台上架商品
	 * @throws SQLException 
	 */
	@Override
	public void pushUp(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update product set pname = ?,market_price=?,shop_price=?,pimage=?,is_hot=?,pdesc= ?,pflag=? where pid = ?";
		Object[] params = { product.getPname(), product.getMarket_price(), product.getShop_price(),
				product.getPimage(),product.getIs_hot(), product.getPdesc(), product.getPflag(),product.getPid()
				 };
		queryRunner.update(sql, params);
	}

	/**
	 * 下架界面删除商品
	 * @throws SQLException 
	 */
	@Override
	public void deleteProduct(String pid) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql1 = "update orderItem set pid = null where pid =  ?";
		queryRunner.update(sql1, pid);
		String sql = "delete from product where pid = ?";
		queryRunner.update(sql, pid);
		
	}

	/**
	 * 模糊查询下架商品个数
	 * @throws SQLException 
	 */
	@Override
	public Integer searchOldProductCount(String productKeywords) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select count(*) from product where pflag = ? and pname like ?";
		Long count = (Long) queryRunner.query(sql, new ScalarHandler(), 1,"%"+productKeywords+"%");
		return count.intValue();
	}

	/**
	 * 模糊查询下架商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> searchOldProduct(String productKeywords, int begin,Integer pageSize) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "select * from product where pflag = ? and pname like ? order by pdate desc limit ?,?";
		List<Product> list = queryRunner.query(sql, new BeanListHandler<Product>(Product.class) ,1,productKeywords,begin,pageSize );
		return list;
	}

	/**
	 * 更新修改商品
	 * @throws SQLException 
	 */
	@Override
	public void updateProduct(Product product) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0JDBCUtils.getDataSource());
		String sql = "update product set pname=?,market_price=?,shop_price=?,pimage=?,pdate=?,is_hot=?,pdesc=?,pflag=?,cid=? where pid = ?";
		Object[] params = {product.getPname(),product.getMarket_price(),product.getShop_price(),product.getPimage(),
				new Date(),//product.getPdate()数据库设置的是date日期类型,实体里是String
				product.getIs_hot(),product.getPdesc(),product.getPflag(),product.getCategory().getCid(),product.getPid()};
		queryRunner.update(sql, params);
		
	}

	
}








