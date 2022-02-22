package com.bitwin.bangbang;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import lombok.AllArgsConstructor;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/main/*")
@AllArgsConstructor
public class MainController {
	
	
	@GetMapping("/mainpage")
	public void mainpage() {
		

		
	}
	
}
