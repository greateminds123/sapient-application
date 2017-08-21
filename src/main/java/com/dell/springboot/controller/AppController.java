package com.dell.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @RequestMapping("/")
	String home(ModelMap model){
    	model.addAttribute("title", "Sapient Product");
		return "index";
    }
	
    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page){
    	return page;
    }
	
}
