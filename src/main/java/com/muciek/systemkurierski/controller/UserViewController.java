/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/user")
public class UserViewController {
    
    @Autowired
    ShipmentService ShipmentService;

    public ShipmentService getShipmentService() {
        return ShipmentService;
    }

    public void setShipmentService(ShipmentService ShipmentService) {
        this.ShipmentService = ShipmentService;
    }
    
    
    
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
    
    @RequestMapping("/profile")
    public String profile(){
        return "user/partials/profile";
    }
    
    @RequestMapping("/newPackage")
    public String newPackage(){
        return "user/partials/newPackage";
    } 
    
    @RequestMapping(value = "/newPackage/pdf/{id}",method = RequestMethod.GET)
    public ModelAndView getPdfView(@PathVariable("id") String id){ 
        
        Shipment shipment = getShipmentService().getById(Integer.parseInt(id));
        ModelAndView mav = new ModelAndView("pdfView", "shipment", shipment);
        return mav;
    } 
}
