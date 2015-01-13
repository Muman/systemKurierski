/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/user")
public class UserViewController {
    
    @RequestMapping("/")
    public String user(){
        return "user/index";
    }
    
    @RequestMapping("/packageOptions")
    public String packageOptions(){
        return "user/partials/packageOptions";
    }
    
    @RequestMapping("/locations")
    public String locations(){
        return "user/partials/locations";
    }
    
}
