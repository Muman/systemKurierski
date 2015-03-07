/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.Track;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
public class TrackScheduleService {
    
    private ShipmentService shipmentService;
    
    private List<Track> generateTracksForLocation(Location location){
        if(null == location){
            throw new NullPointerException("location null");
        }
        
        List<Shipment> shipmentsToSchedule = shipmentService.getAllShipmentsReadyToProcessInLocation(location);
        
        // dispatch shipments to couriers
        
        // foreach group get track from google Directions API
        
            //change response into TrakcPoint and Track models
        
        return null;
    }
}
