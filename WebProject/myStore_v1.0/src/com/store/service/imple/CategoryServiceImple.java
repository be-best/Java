package com.store.service.imple;

import java.sql.SQLException;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.store.dao.CategoryDao;
import com.store.domain.Category;
import com.store.service.CategoryService;
import com.store.utils.BeanFactory;
/**
 * �����Service��ʵ����
 * @author admin
 * ע�⵼����Category���𵼴���...�ָ��˰���...
 */
public class CategoryServiceImple implements CategoryService {

	@Override
	public List<Category> findAll()throws SQLException {
		/**
		 * ʹ�û����Ż�����,�ȴӻ����л�ȡ����
		 *   * ��ȡ��:ֱ�ӷ���
		 *   * ��ȡ����:��ѯ���ݿ�,����¼���뵽������.
		 */
		// ��ȡ�����ļ�
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		// �������ļ��л�ȡ����ΪcategoryCache������
		Cache cache = cacheManager.getCache("categoryCache");
		// �жϻ������Ƿ���list����:
		Element element = cache.get("list");
		List<Category> list = null;
		if(element == null){
			// ������û������
			System.out.println("������û������ ,��ѯ���ݿ�=====");
			//�����ݿ������
			CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
			list = categoryDao.findAll();
			//���������ݴ��뻺����
			element = new Element("list",list); 
			cache.put(element);
		}else{
			// �������Ѿ���������
			System.out.println("������������ ,û�в�ѯ���ݿ�=====");
			list = (List<Category>)element.getObjectValue();
			
		}
		return list;
	}

	/**
	 * ��ӷ���
	 */
	@Override
	public void save(Category category) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		categoryDao.save(category);
		
		//��ջ���,�����Ż��ȡ�µ����ݵ�ǰ̨��
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		// �������ļ��л�ȡ����ΪcategoryCache������
		Cache cache = cacheManager.getCache("categoryCache");
		//�ӻ������Ƴ�list
		cache.remove("list");
		
	}

	/**
	 * ����ID��ѯ����
	 * @throws SQLException 
	 */
	@Override
	public Category findByCid(String cid) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		Category category = categoryDao.findByCid(cid);
		return category;
	}

	/**
	 * �޸ķ���
	 * @throws SQLException 
	 */
	@Override
	public void update(Category category) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		categoryDao.update(category);
		
		//�������
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//�������ļ��л�ȡ����ΪcategoryCache�Ļ�����
		Cache cache = cacheManager.getCache("categoryCache");
		//�ӻ������Ƴ�list
		cache.remove("list");
	}

	/**
	 * ɾ������
	 * @throws SQLException 
	 */
	@Override
	public void delete(String cid) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		categoryDao.detete(cid);
		
		//�������
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//�������ļ��л�ȡ����ΪcategoryCache�Ļ�����
		Cache cache = cacheManager.getCache("categoryCache");
		//�ӻ������Ƴ�list
		cache.remove("list");
	}

}







