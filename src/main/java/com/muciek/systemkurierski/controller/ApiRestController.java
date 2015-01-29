/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.service.CourierService;
import com.muciek.systemkurierski.service.LocationService;
import com.muciek.systemkurierski.service.PackageOptionService;
import com.muciek.systemkurierski.service.PackageStatusService;
import com.muciek.systemkurierski.service.RecipientService;
import com.muciek.systemkurierski.service.ShipmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muman
 */
@RestController
@RequestMapping("api/")
public class ApiRestController {
    
    @Autowired
    private LocationService locationService;
    
    @Autowired    
    private PackageOptionService packageOptionService;
    
    @Autowired    
    private CourierService courierService;
    
    @Autowired
    private ShipmentService shipmentService;
    
    @Autowired
    private PackageStatusService packageStatusService;
    
    @Autowired
    private RecipientService recipientService;

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public PackageOptionService getPackageOptionService() {
        return packageOptionService;
    }

    public void setPackageOptionService(PackageOptionService packageOptionService) {
        this.packageOptionService = packageOptionService;
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

    public PackageStatusService getPackageStatusService() {
        return packageStatusService;
    }

    public void setPackageStatusService(PackageStatusService packageStatusService) {
        this.packageStatusService = packageStatusService;
    }

    public RecipientService getRecipientService() {
        return recipientService;
    }

    public void setRecipientService(RecipientService recipientService) {
        this.recipientService = recipientService;
    }
    
    @RequestMapping("/locations")
    public List<Location> getAllLocations(){
        return getLocationService().getAllLocations();
    }
    
    @RequestMapping("/locations/{id}")
    public Location getLocationById(@PathVariable("id") String id){
        return getLocationService().getLocationById(Integer.valueOf(id));
    }
    
    @RequestMapping("/couriers")
    public List<Courier> getAllCouriers(){
        return getCourierService().getAllCouriers();
    }
    
    @RequestMapping("/couriers/{id}")
    public Courier getCourierWithId(@PathVariable("id") String id){
        return getCourierService().getCourierById(Integer.valueOf(id));
    }
    
    @RequestMapping("/packages")
    public List<Courier> getAllPackages(){
        return getCourierService().getAllCouriers();
    }
    
    @RequestMapping("/packages/{id}")
    public Shipment getPackageWithId(@PathVariable("id") String id){
        return getShipmentService().getById(Integer.valueOf(id));
    }
    
    @RequestMapping("/packages/{id}/packageStatuses")
    public List<PackageStatus> getAllPackageStatusesForPackageWithId(@PathVariable("id") String id){
        List<PackageStatus> packageStatses = getPackageStatusService().getAllWithPackageId(Integer.valueOf(id));
        return packageStatses;
    }
    
    @RequestMapping("/packages/{packageId}/packageStatuses/{id}")
    public PackageStatus getPackageStatusWithId(@PathVariable("id") String id,@PathVariable("packageId") String packageId){
        PackageStatus packageStatus = getPackageStatusService().getById(Integer.valueOf(id));
        return packageStatus;
    }
    
    
//    @RequestMapping("/users")
//    public @ResponseBody List<Courier> getAllCouriers(){
//        return getCourierService().getAllCouriers();
//    }
//    
//    @RequestMapping("/couriers/{id}")
//    public @ResponseBody Courier getCourierWithId(@RequestParam("id") String id){
//        return getCourierService().getCourierById(Integer.valueOf(id));
//    }
    
    
}