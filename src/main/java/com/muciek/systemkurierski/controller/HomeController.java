/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/welcome")
public class HomeController {
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is admin page!");
		
		model.setViewName("admin");

		return model;

	}
	
	@RequestMapping(value = "/adminprofile**", method = RequestMethod.GET)
	public ModelAndView adminProfile() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is admin profile page!");
		
		model.setViewName("adminprofile");

		return model;

	}
	
	@RequestMapping(value = "/guest**", method = RequestMethod.GET)
	public ModelAndView guestPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is guest  page!");
		
		model.setViewName("guest");

		return model;

	}
	
	@RequestMapping(value = "/user**", method = RequestMethod.GET)
	public ModelAndView userPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is user  page!");
		
		model.setViewName("user");

		return model;

	}
}
