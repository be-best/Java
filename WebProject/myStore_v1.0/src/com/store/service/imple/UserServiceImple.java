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
	 * �첽У���û���
	 */
	@Override
	public User findByUsername(String username) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.findByUsername(username);
	}

	/**
	 * �û�ע��
	 * @throws SQLException 
	 */
	@Override
	public void saveUser(User newUser) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		//�����û�id
		String uid = UUIDUtils.getUUID();
		newUser.setUid(uid);
		//����״̬
		newUser.setState(2);//1����δ���2������
		//���ü�����
		//String code = UUIDUtils.getUUID()+UUIDUtils.getUUID();
		//newUser.setCode(code);
		userDao.saveUser(newUser);
		
		//���ͼ����ʼ�
		//MailUtils.sendMail(newUser.getEmail(), code);
	}

	/** 
	 * �û�����
	 * @throws SQLException 
	 
	@Override
	public User findByCode(String code) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		return userDao.findByCode(code);
	}
	*/
	/**
	 * ������޸�״̬��
	 * @throws SQLException 
	 
	@Override
	public void updateUser(User user) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		userDao.updateUser(user);
		
	}
*/
	
	/**
	 * �û���¼
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
	 * ����Ա��½
	 * @throws SQLException 
	 */
	@Override
	public Adminer adminLogin(Adminer adminer) throws SQLException {
		UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
		Adminer existAdminer =  userDao.adminLogin(adminer);
		return existAdminer;
	}
	
	


}
