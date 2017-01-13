package com.syed.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String getMovie(ModelMap model) {

		model.addAttribute("name", "");
		return "list";

	}
	
	
	@RequestMapping(value="/greeting/{name}", method = RequestMethod.GET)
	public String getMovie(@PathVariable String name, ModelMap model) {

		model.addAttribute("name", name);
		return "list";

	}
	
}