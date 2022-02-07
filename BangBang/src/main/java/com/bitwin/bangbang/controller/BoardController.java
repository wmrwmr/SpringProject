package com.bitwin.bangbang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bitwin.bangbang.domain.Criteria;
import com.bitwin.bangbang.domain.PageDTO;
import com.bitwin.bangbang.domain.notice_boardVO;
import com.bitwin.bangbang.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		
		log.info("list: " + cri);
		
		model.addAttribute("list", service.getList(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, 225));
		
	}
	
	
	
	@PostMapping("/register")
	public String register(notice_boardVO board, RedirectAttributes rttr) {
		
		log.info("register: " + board);
		
		service.register(board);
		
		rttr.addFlashAttribute("result", board.getNidx());
		
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("nidx") Long nidx, Model model) {
		
		log.info("/get or modify");
		model.addAttribute("board", service.get(nidx));
		
	}
	
	@PostMapping("/modify")
	public String modify(notice_boardVO board, RedirectAttributes rttr) {
		
		log.info("modify: " + board);
		
		if(service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
			
		}
		return "redirect:/board/list";
	}
	
	
	@PostMapping("/remove")
	public String remove(@RequestParam("nidx") Long nidx, RedirectAttributes rttr) {
		
		log.info("remove..." + nidx);
		
		if(service.remove(nidx)) {
			
			rttr.addFlashAttribute("result", "success");
			
		}
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/register")
	public void register() {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
