package com.itheima.product.service;

import com.itheima.product.dao.UserDao;
import com.itheima.product.domain.User;
import com.itheima.product.exception.UserException;

import java.sql.SQLException;

public class UserService {

    UserDao ud = new UserDao();

    public void regist(User user) throws UserException {
        try {
            ud.addUser(user);//�û�ע��
            String emailMsg = "ע��ɹ�����<a href='http://www.product.com/activeServlet?activeCode=" + user.getActiveCode() + "'>����</a>���¼";
            //��δʵ��java��¼QQ���䷢���ʼ�
            //SendJMail.sendMail(user.getEmail(), emailMsg);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("ע��ʧ�ܣ�");
        }
    }

    public void activeUser(String activeCode) throws UserException {
        //���ݼ���������û�
        try {
            User user = ud.findUserByActiveCode(activeCode);
            if (user != null) {
                //�����û�
                ud.activeCode(activeCode);
                return;
            }
            throw new UserException("����ʧ��!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("����ʧ��!");
        }
    }

    public User login(String username, String password) throws UserException {
        User user = null;
        try {
            user = ud.findUserByUserNameAndPassword(username, password);
            if (user == null) {
                throw new UserException("�û������������!");
            }
            if (user.getState() == 0) {
                throw new UserException("�û�δ����!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserException("�û������������!");
        }
        return user;
    }
}
