package com.bitcamp.op.member.domain;

public class MemberLoginRequest {

	private String url;
	private String userid;
	private String pw;
	private String saveid;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSaveid() {
		return saveid;
	}

	public void setSaveid(String saveid) {
		this.saveid = saveid;
	}

	@Override
	public String toString() {
		return "MemberLoginRequest [url=" + url + ", userid=" + userid + ", pw=" + pw + ", saveid=" + saveid + "]";
	}
	
	public LoginParams getLoginParams() {
		return new LoginParams(userid, pw);
	}
	
	
	
	
	
	
	
	
	

}
