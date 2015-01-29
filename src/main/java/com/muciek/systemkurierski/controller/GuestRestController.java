/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.PackageOption;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.service.CourierService;
import com.muciek.systemkurierski.service.LocationService;
import com.muciek.systemkurierski.service.PackageOptionService;
import com.muciek.systemkurierski.service.PackageStatusService;
import com.muciek.systemkurierski.service.ShipmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/")
public class GuestRestController {

    @Autowired
    CourierService courierService;

    @Autowired
    LocationService locationService;

    @Autowired
    PackageOptionService packageOptionService;

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    PackageStatusService packageStatusService;

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

    public CourierService getCourierService() {
        return courierService;
    }

    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }

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

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public @ResponseBody
    List<Location> getAllLocations() {
        List<Location> allLocationsList = getLocationService().getAllLocations();
        return allLocationsList;
    }

    @RequestMapping(value = "/location/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Location getLocation(@PathVariable("id") String id) {
        return getLocationService().getLocationById(Integer.valueOf(id));
    }

    @RequestMapping(value = "/packageOption", method = RequestMethod.GET)
    public @ResponseBody
    List<PackageOption> getAllPackageOptions() {
        return getPackageOptionService().getAllPackageOptions();
    }

    @RequestMapping(value = "/packageOption/{id}")
    public @ResponseBody
    PackageOption getPackageOptionById(@PathVariable("id") String id) {
        PackageOption packageOption = getPackageOptionService().getPackageOptionById(Integer.valueOf(id));
        return packageOption;
    }
    
        @RequestMapping(value = "/package/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Shipment getPackage(@PathVariable("id") String id) {
        Shipment shipment = getShipmentService().getById(Integer.valueOf(id));
        return shipment;
    }

    @RequestMapping(value = "/package", method = RequestMethod.GET)
    public @ResponseBody
    List<Shipment> getUserPackages() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Shipment> userPackages = getShipmentService().getAllPackagesForUser(userName);
        return userPackages;
    }

    @RequestMapping(value = "/package/{id}/packageStatus", method = RequestMethod.GET)
    public @ResponseBody
    List<PackageStatus> getPackageStatusesForPAckageWithId(@PathVariable("id") String id) {
        List<PackageStatus> packageStatuses = getPackageStatusService().getAllWithPackageId(Integer.valueOf(id));
        return packageStatuses;
    }
}
