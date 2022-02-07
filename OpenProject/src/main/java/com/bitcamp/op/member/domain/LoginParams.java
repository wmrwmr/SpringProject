package com.bitcamp.op.member.domain;

public class LoginParams {
	
	private String uid;
	private String pw;
	
	public LoginParams() {
	}

	public LoginParams(String uid, String pw) {
		this.uid = uid;
		this.pw = pw;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	
	
	
	
	
	

}
