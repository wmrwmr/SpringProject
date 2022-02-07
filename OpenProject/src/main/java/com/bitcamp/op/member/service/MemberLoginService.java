package com.bitcamp.op.member.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bitcamp.op. member.dao.JdbcTemplateMemberDao;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.dao.mybatisMemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.MemberLoginRequest;
import com.bitcamp.op.member.exception.LoginInvalidException;

@Service
public class MemberLoginService {

	//@Autowired
	//private MemberDao dao;
	
	//@Autowired
	//private JdbcTemplateMemberDao dao;
	
	//@Autowired
	//private mybatisMemberDao dao;
	
	private MemberDao dao;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	public String login(MemberLoginRequest loginRequest, HttpSession session, HttpServletResponse response)
			throws Exception {

		String viewName = null;
		//Connection conn = null;
		Member member = null;
		
		dao = template.getMapper(MemberDao.class);

		//try {
			//conn = ConnectionProvider.getConnection();

			//member = dao.selectByIdPw(conn, loginRequest.getUserid(), loginRequest.getPw());
			//member = dao.selectByIdPw(loginRequest.getUserid(), loginRequest.getPw());
			//member = dao.selectByIdPw(loginRequest.getLoginParams());
			//member = dao.selectByIdPw(loginRequest.getUserid(), loginRequest.getPw());
			member = dao.selectById(loginRequest.getUserid());

			if (member == null) {
				throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
			} else if(!encoder.matches(loginRequest.getPw(), member.getPassword()) ) {
				// 사용자가 입력한 비밀번호와 Member 객체가 가지고 있는 비밀번호를 확인
				throw new LoginInvalidException("아이디 또는 비밀번호가 틀립니다.");
			}

			// 로그인 처리와 viewName 정의, 쿠키 처리
			// 로그인 : session 속성에 데이터 저장
			session.setAttribute("loginInfo", member.getLoginInfo());

			// id 저장하기 체크 처리 : checked 상태 -> "on" -> 쿠키 저장
			if (loginRequest.getSaveid() != null && loginRequest.getSaveid().equals("on")) {

				Cookie c = new Cookie("saveId", loginRequest.getUserid());
				response.addCookie(c);

			}

			if (loginRequest.getUrl().length() > 0) {
				viewName = "redirect:" + loginRequest.getUrl();
			} else {
				viewName = "redirect:/";
			}

		//} finally {
		//	JdbcUtil.close(conn);
		//}

		return viewName;
	}

}
