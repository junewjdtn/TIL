package com.test.chap04.model.dto;

import java.util.Date;

public class User {

	// �ʵ�
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;
	
	// ������(�⺻������, �Ű�����������)
	// �⺻������
	public User() {}
	
	// �Ű����� ������
	public User(String userId, String userPwd, String userName) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
	public User(String userId, String userPwd, String userName, Date enrollDate) {
		/*this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;*/
		this(userId, userPwd, userName);
		this.enrollDate = enrollDate;
	}
	
	// getter&setter 
	// getter (���� �����ö� ���)
	public String getuserId() {
		return userId;
	}
	public String getuserPwd() {
		return userPwd;
	}
	public String getuserName() {
		return userName;
	}
	public Date getenrollDate() {
		return enrollDate;
	}
	
	//setter (���� ������ �� ���)
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd; // �ʵ� = �Ű�����
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	// information()
	public void information() {
		System.out.println(userId + ", " + userPwd + ", " + userName + ", " + enrollDate);
	}
	
	
	
}
