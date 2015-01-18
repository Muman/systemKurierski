/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.exception.EmailAlreadyInUseException;
import com.muciek.systemkurierski.exception.UsernameAlreadyInUseException;
import com.muciek.systemkurierski.models.NewUserWrapper;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.models.UserInfo;
import com.muciek.systemkurierski.service.RegisterService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/")
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;

    public RegisterService getRegisterService() {
        return registerService;
    }

    public void setRegisterService(RegisterService RegisterService) {
        this.registerService = RegisterService;
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST) 
    public @ResponseBody void registerUser(@RequestBody NewUserWrapper newUserWrapper)  throws Exception, UsernameAlreadyInUseException, EmailAlreadyInUseException{
        getRegisterService().register(newUserWrapper);
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegistrationPage(){
        return "register";
    }
}
