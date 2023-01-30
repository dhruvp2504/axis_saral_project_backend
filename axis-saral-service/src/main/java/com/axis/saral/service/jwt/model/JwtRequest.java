package com.axis.saral.service.jwt.model;

public class JwtRequest {

	String userName;
	String password;
	String role;
	public JwtRequest() {
		super();
	}
	public JwtRequest(String userName, String password, String role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "JwtRequest [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
