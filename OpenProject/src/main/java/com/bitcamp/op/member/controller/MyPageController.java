package com.bitcamp.op.member.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.service.MemberMyPageService;

@Controller
@RequestMapping("/member/my")
public class MyPageController {
	
	@Autowired
	private MemberMyPageService myPageService;

	@RequestMapping("/mypage")
	public void getMyPage(
			HttpSession session,
			Model model
			) throws SQLException {
		model.addAttribute("member", myPageService.getMember(session));
	}
	
}
