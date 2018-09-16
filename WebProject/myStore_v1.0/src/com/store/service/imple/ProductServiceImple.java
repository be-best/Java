package com.store.service.imple;

import java.sql.SQLException;
import java.util.List;

import com.store.dao.ProductDao;
import com.store.domain.PageBean;
import com.store.domain.Product;
import com.store.service.ProductService;
import com.store.utils.BeanFactory;

public class ProductServiceImple implements ProductService {

	/**
	 * 查询热门推荐商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByHot() throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		List<Product> hotList = productDao.findByHot();
		return hotList;
	}

	/**
	 * 查询最新商品
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByNew() throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		List<Product> newList = productDao.findByNew();
		return newList;
	}

	/**
	 * 根绝cid分类查找商品
	 * @return 
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> findByCid(String cid, Integer currPage) throws SQLException {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置参数：
		// 设置当前页数：
		pageBean.setCurrPage(currPage);
		// 设置每页显示的记录数:
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		// 设置总记录数:
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Integer totalCount = productDao.findByCid(cid);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示的数据的集合:
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findPageByCid(cid,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 根据pid查询商品
	 * @throws SQLException 
	 */
	@Override
	public Product findByPid(String pid) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Product product = productDao.findByPid(pid);
		return product;
	}

	/**
	 * 搜索框模糊查询
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> searchProduct(String productKeywords,Integer currPage) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		PageBean<Product> pageBean = new PageBean();
		//设置当前页
		pageBean.setCurrPage(currPage);
		//设置每页的容量
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		//总个数
		Integer totalCount = productDao.searchCount(productKeywords);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double totalC = totalCount;
		Double totalPage = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//设置商品集合
		int begin = (currPage-1)*pageSize;
		List<Product> list = productDao.searchProduct(productKeywords,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 后台查询所有商品
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> findByPage(Integer currPage) throws SQLException {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置参数：
		// 设置当前页数：
		pageBean.setCurrPage(currPage);
		// 设置每页显示的记录数:
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		// 设置总记录数:
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Integer totalCount = productDao.findByCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示的数据的集合:
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 添加product
	 * @throws SQLException 
	 */
	@Override
	public void addProduct(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.addProduct(product);
		
	}

	/**
	 * 下架商品
	 * @throws SQLException 
	 */
	@Override
	public void pushDown(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.pushDown(product);
		
	}

	/**
	 * 查询显示下架商品
	 * @throws SQLException 
	 */
	@Override
	public PageBean findByPushDown(Integer currPage) throws SQLException {
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置参数：
		// 设置当前页数：
		pageBean.setCurrPage(currPage);
		// 设置每页显示的记录数:
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		// 设置总记录数:
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Integer totalCount = productDao.findCountByPushDown();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// 设置每页显示的数据的集合:
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findPageByPushDown(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	/**
	 * 上架商品
	 * @throws SQLException 
	 */
	@Override
	public void pushUp(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.pushUp(product);
	}

	/**
	 * 下架界面删除商品
	 * @throws SQLException 
	 */
	@Override
	public void deleteProduct(String pid) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.deleteProduct(pid);
	}

	/**
	 * 模糊查询下架商品
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> searchOldProduct(String productKeywords,Integer currPage) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		PageBean<Product> pageBean = new PageBean();
		//设置当前页
		pageBean.setCurrPage(currPage);
		//设置每页的容量
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		//总个数
		Integer totalCount = productDao.searchOldProductCount(productKeywords);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		double totalC = totalCount;
		Double totalPage = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//设置商品集合
		int begin = (currPage-1)*pageSize;
		List<Product> list = productDao.searchOldProduct(productKeywords,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * 更新修改商品
	 * @throws SQLException 
	 */
	@Override
	public void updateProduct(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.updateProduct(product);
		
	}


}




