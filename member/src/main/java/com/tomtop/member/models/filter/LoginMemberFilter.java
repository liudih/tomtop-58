package com.tomtop.member.models.filter;

import com.tomtop.member.models.base.FilterBaseBean;


public class LoginMemberFilter extends FilterBaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8560802821562783178L;
	private String email = "";
	private String pwd = "";
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
