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
		
		String from = "2804238230@qq.com"; 				// �ʼ������˵��ʼ���ַ
		String to = email; 									// �ʼ������˵��ʼ���ַ
//		final String username = "mailName";  		//�����˵��ʼ��ʻ�
//		final String password = "password";   				//�����˵��ʼ�����


//		//����Properties����,���û�����Ϣ
//		Properties props = new Properties();
//
//		//�����ʼ��������ĵ�ַ
//		props.setProperty("mail.transport.protocol", "smtp");//���÷����ʼ�ʹ�õ�Э��
//		props.setProperty("mail.smtp.host", "smtp.qq.com"); // ָ����smtp������
//		props.setProperty("mail.smtp.auth", "true");
//		//����Session����,session�����ʾ�����ʼ��Ļ�����Ϣ
//		Session session = Session.getInstance(props);
//		//�������������Ϣ
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
		                    return new PasswordAuthentication("��Ȩ��",
		                            "from���俪��smtp����ʱ��Ѷ������Ȩ��");
		                }
		            };
		            Session session = Session.getDefaultInstance(properties,
		                    authenticator);
		            session.setDebug(true);
		            Message message = new MimeMessage(session);
		            message.setFrom(new InternetAddress(from));
		            message.setRecipient(Message.RecipientType.TO, new InternetAddress(
		                    to));
		            message.setSubject("BookStore��Ա�˻�����");
		            message.setContent(
		                    "�����˻�",
		                    "text/html;charset=UTF-8");
		            Transport.send(message);
		            return true;

		        } catch (Exception e) {
		        	e.printStackTrace();
		        	return false;
		        }
		
		}
		
//		try {
//			//Message��ʵ�������ʾһ������ʼ�
//			MimeMessage message = new MimeMessage(session);
//			//���÷����˵ĵ�ַ
//			message.setFrom(new InternetAddress(from));
//			//��������
//			message.setSubject("�û�����");
//			//�����ʼ����ı�����
//			//message.setText("Welcome to JavaMail World!");
//			message.setContent(emailMsg,"text/html;charset=utf-8");// ע��ɹ�����<a href='http://www.product.com?activeCode=ffddff14'>����</a>���¼
//			//��session�Ļ����л�ȡ�����ʼ��Ķ���
//			Transport transport = session.getTransport();
//			//�����ʼ�������
//			transport.connect("smtp.qq.com",465, username, password);
//			//�����ռ��˵�ַ,��������Ϣ
//			transport.sendMessage(message,new Address[]{new InternetAddress(to)});
//			transport.close();
//			return true;
//		} catch (MessagingException e) {
//			e.printStackTrace();
//			return false;
//		}
//	}
	
}
