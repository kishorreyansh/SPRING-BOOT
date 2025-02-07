package com.thymeleaf.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymeLeafController {

	//@RequestMapping(value="/about",method=RequestMethod.GET)
	@GetMapping("/about")
	public String about(Model model) {
		System.out.println("Inside About Handler");
		model.addAttribute("name","Reyansh");
		model.addAttribute("date", new Date().toLocaleString());
		return "about";  //about.html
	}
	
	@GetMapping("/iterate")
	public String iterate(Model model) {
		List<String> names = List.of("Reyansh","Ridhansh","Kishor","Salaar");
		model.addAttribute("names",names);
		return "iterate";
	}
	
	@GetMapping("/conditions")
	public String conditionalStatements(Model model) {
		model.addAttribute("isActive", false);
		model.addAttribute("gender", "F");
		List<Integer> lists = List.of(17,23,05,01,13,24,18);
		model.addAttribute("mylist", lists);
		return "conditions";
	}
	
	@GetMapping("/fragmentservice")
	public String fragment(Model model) {
		System.out.println("Fragment Handler Invoked");
		model.addAttribute("title", "This is Thymeleaf");
		model.addAttribute("subtitle","This is Sub Title");
		return "fregmentservice";
	}
	
	@GetMapping("/newabout")
	public String newAbout() {
		return "aboutnew";
	}
}
