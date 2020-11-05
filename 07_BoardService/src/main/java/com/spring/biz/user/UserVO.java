package com.spring.biz.user;

/*
CREATE TABLE USERS (
	    ID VARCHAR2(20) PRIMARY KEY,
	    PASSWORD VARCHAR2(20) NOT NULL,
	    NAME VARCHAR2(30),
	    ROLE VARCHAR2(5)
	);
	*/

public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
	
	public UserVO() {
		System.out.println(">> UserVO() 객체 생성");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", name=" + name + ", role=" + role + "]";
	}
	
	
	

}
