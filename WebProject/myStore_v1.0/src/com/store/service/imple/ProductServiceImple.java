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
	 * ��ѯ�����Ƽ���Ʒ
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByHot() throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		List<Product> hotList = productDao.findByHot();
		return hotList;
	}

	/**
	 * ��ѯ������Ʒ
	 * @throws SQLException 
	 */
	@Override
	public List<Product> findByNew() throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		List<Product> newList = productDao.findByNew();
		return newList;
	}

	/**
	 * ����cid���������Ʒ
	 * @return 
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> findByCid(String cid, Integer currPage) throws SQLException {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���ò�����
		// ���õ�ǰҳ����
		pageBean.setCurrPage(currPage);
		// ����ÿҳ��ʾ�ļ�¼��:
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		// �����ܼ�¼��:
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Integer totalCount = productDao.findByCid(cid);
		pageBean.setTotalCount(totalCount);
		// ������ҳ��:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// ����ÿҳ��ʾ�����ݵļ���:
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findPageByCid(cid,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ����pid��ѯ��Ʒ
	 * @throws SQLException 
	 */
	@Override
	public Product findByPid(String pid) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Product product = productDao.findByPid(pid);
		return product;
	}

	/**
	 * ������ģ����ѯ
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> searchProduct(String productKeywords,Integer currPage) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		PageBean<Product> pageBean = new PageBean();
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//����ÿҳ������
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		//�ܸ���
		Integer totalCount = productDao.searchCount(productKeywords);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		double totalC = totalCount;
		Double totalPage = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//������Ʒ����
		int begin = (currPage-1)*pageSize;
		List<Product> list = productDao.searchProduct(productKeywords,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ��̨��ѯ������Ʒ
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> findByPage(Integer currPage) throws SQLException {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���ò�����
		// ���õ�ǰҳ����
		pageBean.setCurrPage(currPage);
		// ����ÿҳ��ʾ�ļ�¼��:
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		// �����ܼ�¼��:
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Integer totalCount = productDao.findByCount();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// ����ÿҳ��ʾ�����ݵļ���:
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * ���product
	 * @throws SQLException 
	 */
	@Override
	public void addProduct(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.addProduct(product);
		
	}

	/**
	 * �¼���Ʒ
	 * @throws SQLException 
	 */
	@Override
	public void pushDown(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.pushDown(product);
		
	}

	/**
	 * ��ѯ��ʾ�¼���Ʒ
	 * @throws SQLException 
	 */
	@Override
	public PageBean findByPushDown(Integer currPage) throws SQLException {
		PageBean<Product> pageBean = new PageBean<Product>();
		// ���ò�����
		// ���õ�ǰҳ����
		pageBean.setCurrPage(currPage);
		// ����ÿҳ��ʾ�ļ�¼��:
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		// �����ܼ�¼��:
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		Integer totalCount = productDao.findCountByPushDown();
		pageBean.setTotalCount(totalCount);
		// ������ҳ��:
		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		// ����ÿҳ��ʾ�����ݵļ���:
		int begin = (currPage - 1) * pageSize;
		List<Product> list = productDao.findPageByPushDown(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	
	/**
	 * �ϼ���Ʒ
	 * @throws SQLException 
	 */
	@Override
	public void pushUp(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.pushUp(product);
	}

	/**
	 * �¼ܽ���ɾ����Ʒ
	 * @throws SQLException 
	 */
	@Override
	public void deleteProduct(String pid) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.deleteProduct(pid);
	}

	/**
	 * ģ����ѯ�¼���Ʒ
	 * @throws SQLException 
	 */
	@Override
	public PageBean<Product> searchOldProduct(String productKeywords,Integer currPage) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		PageBean<Product> pageBean = new PageBean();
		//���õ�ǰҳ
		pageBean.setCurrPage(currPage);
		//����ÿҳ������
		Integer pageSize = 12;
		pageBean.setPageSize(pageSize);
		//�ܸ���
		Integer totalCount = productDao.searchOldProductCount(productKeywords);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		double totalC = totalCount;
		Double totalPage = Math.ceil(totalC/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//������Ʒ����
		int begin = (currPage-1)*pageSize;
		List<Product> list = productDao.searchOldProduct(productKeywords,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	/**
	 * �����޸���Ʒ
	 * @throws SQLException 
	 */
	@Override
	public void updateProduct(Product product) throws SQLException {
		ProductDao productDao = (ProductDao) BeanFactory.getBean("productDao");
		productDao.updateProduct(product);
		
	}


}




