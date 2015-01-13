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
@RequestMapping("/")
public class GuestViewController {
    
    @RequestMapping("/")
    public String guest(){
        return "guest/index";
    }
    
    @RequestMapping("/locations")
    public String guestLocations(){
        return "guest/partials/locations";
    }
    
    @RequestMapping("/packageOptions")
    public String guestPackageOptions(){
        return "guest/partials/packageOptions";
    }
}
