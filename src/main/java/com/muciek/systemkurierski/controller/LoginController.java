/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Muman
 */
@Controller
public class LoginController {
	
	@RequestMapping(value = "/login**", method = RequestMethod.GET)
	public ModelAndView dologin() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

}
