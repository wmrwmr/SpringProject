package com.bitcamp.op.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberIdCheckController {
	
	@Autowired
	private MemberCheckIdService checkIdService;
	
	@RequestMapping("/member/checkid")
	@ResponseBody
	public String checkId(
			@RequestParam("userid") String userId
			) {
		return checkIdService.checkId(userId);
	}

}
