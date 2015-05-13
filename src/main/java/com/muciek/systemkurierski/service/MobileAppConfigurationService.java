/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.MobileAppConfiguration;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Track;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class MobileAppConfigurationService {
    
    @Autowired
    private CourierService courierService;
    
    @Autowired
    private ShipmentService shipmentService;
    
    @Autowired
    private TrackService trackService;

    public TrackService getTrackService() {
        return trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }
    
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
        if(null == courier){         
            return null;
        }
        
        PackageStatus.Type[] packageStatusTypes = PackageStatus.Type.values();
        List<String> allPackageStatusTypes = new ArrayList<String>();
        
        for(PackageStatus.Type packageStatusType : packageStatusTypes){
            allPackageStatusTypes.add(packageStatusType.getStatus());
        }
        
        List<Track> courierTracks = getTrackService().getByCourier(courier);
        
        MobileAppConfiguration newAppConfig = new MobileAppConfiguration();
        newAppConfig.setCourier(courier);
        newAppConfig.setAvaliablePackageStatuses(allPackageStatusTypes);
        newAppConfig.setTracks(courierTracks);
        
        return newAppConfig;
    }
}
