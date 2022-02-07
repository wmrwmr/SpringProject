package com.bitcamp.op.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bitcamp.op.member.domain.Member;

public class MemberRowMapper implements RowMapper<Member> {

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Member(
				rs.getInt("idx"), 
				rs.getString("userid"), 
				rs.getString("password"), 
				rs.getString("username"),
				rs.getString("photo"), 
				rs.getString("regdate"), null
				);
	}

}
