/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.service.CourierService;
import java.util.List;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muman
 */
@RestController
@RequestMapping("/courier")
public class CourierController {
    
    @Autowired
    private CourierService courierService;

    /**
     * @return the courierService
     */
    public CourierService getCourierService() {
        return courierService;
    }

    /**
     * @param courierService the courierService to set
     */
    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }
    
    @RequestMapping(value = "/all.json", method = RequestMethod.GET)
    public @ResponseBody List<Courier> getAllCouriers(){
        return courierService.getAllCouriers();
    }
    
    @RequestMapping(value = "/{id}")
    public @ResponseBody Courier getCourierById(@PathVariable("id") String id){
        Courier requestedCourier = getCourierService().getCourierById(Integer.valueOf(id));
        return requestedCourier;
    }
    
    @RequestMapping(value = "/")
    public String getTodoPartialPage(){
        return "couriers";
    }
}
