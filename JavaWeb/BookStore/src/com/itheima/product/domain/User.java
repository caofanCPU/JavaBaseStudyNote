package com.itheima.product.domain;

import java.util.Date;

/**
 * ʵ���ࣺUser
 * �����ֶε���ƺ���Ҫ�����ݿ��ֶΡ�ʵ���������ֶΡ�jspҳ���ֶα���һ��
 *
 * @author CY_XYZ
 */
public class User {
    private int id; // �û����
    private String userName; // �û�����
    private String password; // �û�����
    private String gender; // �û��Ա�
    private String email; // �û�����
    private String telephone; // �û���ϵ�绰
    private String introduce; // �û�����
    private String activeCode; // ������
    private String role; // �û���ɫ
    private int state; // �û�״̬
    private Date registTime;// ע��ʱ��

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getActiveCode() {
        return activeCode;
    }

    public void setActiveCode(String activeCode) {
        this.activeCode = activeCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

}
