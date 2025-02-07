package com.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddCSSJSImageController {

	@GetMapping("/add")
	public String add() {
		return "addcssjsimage";
	}
}
