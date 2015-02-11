/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.MobileAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Muman
 */
public class MobileAppConfigurationService {
    
    @Autowired
    private CourierService courierService;
    
    @Autowired
    private ShipmentService shipmentService;

    public CourierService getCourierService() {
        return courierService;
    }

    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }

    public ShipmentService getShipmentService() {
        return shipmentService;
    }

    public void setShipmentService(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }
    
    public MobileAppConfiguration getAppConfigForCourier(Courier courier){
        return null;
    }
    
}
