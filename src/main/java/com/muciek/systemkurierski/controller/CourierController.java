/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.service.CourierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<Courier> viewAllTodos(){
        return courierService.getAllCouriers();
    }
}