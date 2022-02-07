package com.bitcamp.op.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.op.member.domain.MemberRegRequest;
import com.bitcamp.op.member.service.MemberRegService;

@Controller
@RequestMapping("/member/reg") // http://localhost:8080/op/member/reg
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@GetMapping
	public String getRegForm() {
		return "member/regform";
	}
	
	@PostMapping
	public void memberReg(
			MemberRegRequest regRequest,
			Model model,
			HttpServletRequest request
			) throws IllegalStateException, IOException, SQLException {
		//System.out.println(regRequest);
		
		
		
		model.addAttribute("result", regService.insertMember(regRequest, request));
		
		System.out.println("@Controller: idx => " + regRequest.getIdx());
		// view 페이지의 idx로 사용해서 redirect 처리 가능
		
	}

}
