package com.bitcamp.op.member.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.service.MemberDeleteService;

@Controller
public class MemberDeleteController {
	
	@Autowired
	private MemberDeleteService deleteService;

	@RequestMapping("/member/manager/delete")
	public String deleteMember(
			@RequestParam("idx") int idx,
			HttpServletRequest request
			) {
		
		deleteService.deleteMember(idx, request);
		
		return "redirect:/member/manager/list";
	}
	
}
