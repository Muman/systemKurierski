/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.exception.EmailAlreadyInUseException;
import com.muciek.systemkurierski.exception.UsernameAlreadyInUseException;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/")
public class RegisterController {
    
    @Autowired
    private RegisterService RegisterService;

    public RegisterService getRegisterService() {
        return RegisterService;
    }

    public void setRegisterService(RegisterService RegisterService) {
        this.RegisterService = RegisterService;
    }
    
    @RequestMapping(value = "/register")
    public @ResponseBody void registerUser(@RequestBody User user)  throws UsernameAlreadyInUseException, EmailAlreadyInUseException{
        getRegisterService().register(user);
    }
    
}
