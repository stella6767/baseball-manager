package com.example.baseballex1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	
	@GetMapping("/")
	public String home() {
	
		return "/index";
	}
	
	
//	@GetMapping("/fieldAdd")
//	public String fieldAdd() {
//	
//		return "/fieldAdd";
//	}
	
	
	
}
