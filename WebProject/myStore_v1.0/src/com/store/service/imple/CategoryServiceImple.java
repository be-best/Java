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
 * 分类的Service的实现类
 * @author admin
 * 注意导包，Category包别导错了...又搞了半天...
 */
public class CategoryServiceImple implements CategoryService {

	@Override
	public List<Category> findAll()throws SQLException {
		/**
		 * 使用缓存优化程序,先从缓存中获取数据
		 *   * 获取到:直接返回
		 *   * 获取不到:查询数据库,将记录存入到缓存中.
		 */
		// 读取配置文件
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		// 从配置文件中获取名称为categoryCache缓存区
		Cache cache = cacheManager.getCache("categoryCache");
		// 判断缓存中是否有list集合:
		Element element = cache.get("list");
		List<Category> list = null;
		if(element == null){
			// 缓存中没有数据
			System.out.println("缓存中没有数据 ,查询数据库=====");
			//到数据库读数据
			CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
			list = categoryDao.findAll();
			//读完后把数据存入缓存中
			element = new Element("list",list); 
			cache.put(element);
		}else{
			// 缓存中已经存在数据
			System.out.println("缓存中有数据 ,没有查询数据库=====");
			list = (List<Category>)element.getObjectValue();
			
		}
		return list;
	}

	/**
	 * 添加分类
	 */
	@Override
	public void save(Category category) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		categoryDao.save(category);
		
		//清空缓存,这样才会读取新的数据到前台上
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		// 从配置文件中获取名称为categoryCache缓存区
		Cache cache = cacheManager.getCache("categoryCache");
		//从缓存中移除list
		cache.remove("list");
		
	}

	/**
	 * 根据ID查询分类
	 * @throws SQLException 
	 */
	@Override
	public Category findByCid(String cid) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		Category category = categoryDao.findByCid(cid);
		return category;
	}

	/**
	 * 修改分类
	 * @throws SQLException 
	 */
	@Override
	public void update(Category category) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		categoryDao.update(category);
		
		//清除缓存
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//从配置文件中获取名称为categoryCache的缓存区
		Cache cache = cacheManager.getCache("categoryCache");
		//从缓存中移除list
		cache.remove("list");
	}

	/**
	 * 删除分类
	 * @throws SQLException 
	 */
	@Override
	public void delete(String cid) throws SQLException {
		CategoryDao categoryDao = (CategoryDao) BeanFactory.getBean("categoryDao");
		categoryDao.detete(cid);
		
		//清除缓存
		CacheManager cacheManager = CacheManager.create(CategoryServiceImple.class.getClassLoader().getResourceAsStream("ehcache.xml"));
		//从配置文件中获取名称为categoryCache的缓存区
		Cache cache = cacheManager.getCache("categoryCache");
		//从缓存中移除list
		cache.remove("list");
	}

}







