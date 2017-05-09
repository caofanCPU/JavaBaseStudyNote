package com.itheima.product.util;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendJMail {
	
		public static boolean sendMail(String email, String emailMsg) {
		
		String from = "2804238230@qq.com"; 				// 邮件发送人的邮件地址
		String to = email; 									// 邮件接收人的邮件地址
//		final String username = "mailName";  		//发件人的邮件帐户
//		final String password = "password";   				//发件人的邮件密码


//		//定义Properties对象,设置环境信息
//		Properties props = new Properties();
//
//		//设置邮件服务器的地址
//		props.setProperty("mail.transport.protocol", "smtp");//设置发送邮件使用的协议
//		props.setProperty("mail.smtp.host", "smtp.qq.com"); // 指定的smtp服务器
//		props.setProperty("mail.smtp.auth", "true");
//		//创建Session对象,session对象表示整个邮件的环境信息
//		Session session = Session.getInstance(props);
//		//设置输出调试信息
//		session.setDebug(true);
		
		
		try {
		    Properties properties = new Properties();
		    properties.setProperty("mail.host", "smtp.qq.com");
		    properties.setProperty("mail.transport.protocol", "smtp");
		    properties.setProperty("mail.smtp.auth", "true");
		    properties.setProperty("mail.smtp.socketFactory.class",
		                    "javax.net.ssl.SSLSocketFactory");
		    properties.setProperty("mail.smtp.port", "465");
		    properties.setProperty("mail.smtp.socketFactory.port", "465");
		    Authenticator authenticator = new Authenticator() {
		                @Override
		                protected PasswordAuthentication getPasswordAuthentication() {
		                    return new PasswordAuthentication("授权码",
		                            "from邮箱开启smtp服务时腾讯给的授权码");
		                }
		            };
		            Session session = Session.getDefaultInstance(properties,
		                    authenticator);
		            session.setDebug(true);
		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(from));
		            message.setRecipient(Message.RecipientType.TO, new InternetAddress(
		                    to));
		            message.setSubject("BookStore会员账户激活");
		            message.setContent(
		                    "激活账户",
		                    "text/html;charset=UTF-8");
		            Transport.send(message);
		            return true;

		        } catch (Exception e) {
		        	e.printStackTrace();
		        	return false;
		        }
		
		}
		
//		try {
//			//Message的实例对象表示一封电子邮件
//			MimeMessage message = new MimeMessage(session);
//			//设置发件人的地址
//			message.setFrom(new InternetAddress(from));
//			//设置主题
//			message.setSubject("用户激活");
//			//设置邮件的文本内容
//			//message.setText("Welcome to JavaMail World!");
//			message.setContent(emailMsg,"text/html;charset=utf-8");// 注册成功，请<a href='http://www.product.com?activeCode=ffddff14'>激活</a>后登录
//			//从session的环境中获取发送邮件的对象
//			Transport transport = session.getTransport();
//			//连接邮件服务器
//			transport.connect("smtp.qq.com",465, username, password);
//			//设置收件人地址,并发送消息
//			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
//			transport.close();
//			return true;
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
}
