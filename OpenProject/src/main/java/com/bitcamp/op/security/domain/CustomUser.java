package com.bitcamp.op.security.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.bitcamp.op.member.domain.Member;

public class CustomUser extends User {

	private static final long serialVersionUID = 1L;

	private Member member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(Member vo) {
		super(vo.getUserid(), vo.getPassword(), makeGrantedAuthority(vo));
		this.member = vo;
	}

	private static List<GrantedAuthority> makeGrantedAuthority(Member vo) {
		List<GrantedAuthority> list = new ArrayList<>();
		System.out.println(vo.getRole());
		list.add(new SimpleGrantedAuthority(vo.getRole()));
		return list;
	}

	public Member getMember() {
		return member;
	}

	@Override
	public String toString() {
		return "CustomUser [member=" + member + "]";
	}
	
	

}
