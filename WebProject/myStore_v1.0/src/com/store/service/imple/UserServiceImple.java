package com.store.service.imple;

import java.sql.SQLException;

import com.store.dao.UserDao;
import com.store.dao.imple.UserDaoImple;
import com.store.domain.Adminer;
import com.store.domain.User;
import com.store.service.UserService;
import com.store.utils.BeanFactory;
import com.store.utils.MailUtils;
import com.store.utils.UUIDUtils;

public class UserServiceImple implements UserService {

	/**
	 * 异步校验用户名
	 */
	@Override
	public User findByUsername(String username) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.findByUsername(username);
	}

	/**
	 * 用户注册
	 * @throws SQLException 
	 */
	@Override
	public void saveUser(User newUser) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		//生成用户id
		String uid = UUIDUtils.getUUID();
		newUser.setUid(uid);
		//设置状态
		newUser.setState(2);//1代表未激活，2代表激活
		//设置激活码
		//String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//newUser.setCode(code);
		userDao.saveUser(newUser);
		
		//发送激活邮件
		//MailUtils.sendMail(newUser.getEmail(), code);
	}

	/** 
	 * 用户激活
	 * @throws SQLException 
	 
	@Override
	public User findByCode(String code) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.findByCode(code);
	}
	*/
	/**
	 * 激活后修改状态码
	 * @throws SQLException 
	 
	@Override
	public void updateUser(User user) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		userDao.updateUser(user);
		
	}
*/
	
	/**
	 * 用户登录
	 * @throws SQLException 
	 */
	@Override
	public User userLogin(User user) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.userLogin(user);
	}

	@Override
	public User findByCode(String code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 管理员登陆
	 * @throws SQLException 
	 */
	@Override
	public Adminer adminLogin(Adminer adminer) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		Adminer existAdminer =  userDao.adminLogin(adminer);
		return existAdminer;
	}
	
	


}
