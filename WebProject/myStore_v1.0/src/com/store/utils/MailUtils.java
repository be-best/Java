package com.store.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * �����ʼ��Ĺ�����:
 * @author admin
 *
 */
public class MailUtils {

	public static void sendMail(String to,String code){
		
		try {
			// �������:
			Properties props = new Properties();
			Session session = Session.getInstance(props, new Authenticator() {

				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("service@store.com", "111");
					//return new PasswordAuthentication("gaojistore@sina.com", "nba2konline");
				}
				
			});
			// �����ʼ�:
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("service@store.com"));
			//message.setFrom(new InternetAddress("gaojistore@sina.com"));
			// �����ռ���:
			// TO:�ռ���   CC:����   BCC:����,����.
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// ����:
			message.setSubject("���Ը��Store�ļ����ʼ�!");
			// ����:
			message.setContent("<h1>���Ը��Store�ļ����ʼ�:�����������Ӽ���!</h1><h3><a href='http://localhost:8080/myStore_v1.0/UserServlet?method=active&code="+code+"'>http://localhost:8080/myStore_v1.0/UserServlet?method=active&code="+code+"</a></h3>", "text/html;charset=UTF-8");
		
			// �����ʼ�:
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
//		MailUtils.sendMail("aaa@store.com", "123sdfjklsdkljrsiduoi1123");
//	}
}
