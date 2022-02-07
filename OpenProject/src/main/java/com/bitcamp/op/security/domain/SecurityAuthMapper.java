package com.bitcamp.op.security.domain;

import com.bitcamp.op.member.domain.Member;

public interface SecurityAuthMapper {
	
	public Member getInfo(String userId);

}
