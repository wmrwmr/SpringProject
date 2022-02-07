package com.bitcamp.op.member.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.op.member.domain.EditRequest;
import com.bitcamp.op.member.service.MemberEditService;

@Controller
@RequestMapping("/member/manager/edit")
public class MemberEditController {
	
	@Autowired
	private MemberEditService editService;
	
	@GetMapping
	public String form(
			@RequestParam("idx") int idx,
			Model model
			) {
		
		model.addAttribute("member", editService.getMember(idx));
		
		return "member/manager/editform";
	}
	
	@PostMapping
	public String edit(
			EditRequest editRequest,
			HttpServletRequest request
			) throws IllegalStateException, IOException {
		
		System.out.println(editRequest);
		
		editService.editMember(editRequest, request);
		
		return "redirect:/member/manager/list";
	}

}
