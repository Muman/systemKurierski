/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Courier;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class CourierAuthenticateService {
    @Autowired
    private CourierService courierService;
    
    public CourierService getCourierService() {
        return courierService;
    }

    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }
    
    public boolean authenticateCourier(String login, String password){
       Courier courier = getCourierService().getCourierByLogin(login);
       
       if(courier.getPasswod().equals(password)){
           return true;
       }
       
       return false;
    }
    
}
