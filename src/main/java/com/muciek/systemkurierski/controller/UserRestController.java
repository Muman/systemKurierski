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
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.models.UserInfo;
import com.muciek.systemkurierski.service.CourierService;
import com.muciek.systemkurierski.service.LocationService;
import com.muciek.systemkurierski.service.PackageOptionService;
import com.muciek.systemkurierski.service.PackageStatusService;
import com.muciek.systemkurierski.service.ShipmentService;
import com.muciek.systemkurierski.service.UserInfoService;
import com.muciek.systemkurierski.service.UserService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Muman
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

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
    
    @Autowired
    UserService userService;
    
    @Autowired
    UserInfoService userInfoService;

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public PackageStatusService getPackageStatusService() {
        return packageStatusService;
    }

    public void setPackageStatusService(PackageStatusService packageStatusService) {
        this.packageStatusService = packageStatusService;
    }

    public ShipmentService getShipmentService() {
        return shipmentService;
    }

    public void setShipmentService(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
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

    @RequestMapping(value = "/newPackage", method = RequestMethod.POST)
    public void registerShipment(@RequestBody Shipment shipment) {
        getShipmentService().add(shipment);
    }
    
    @RequestMapping(value = "/package/{id}", method = RequestMethod.GET)
    public @ResponseBody Shipment getPackage(@PathVariable("id") String id) {
        Shipment shipment = getShipmentService().getById(Integer.valueOf(id));
        return shipment;
    }
    
    @RequestMapping(value = "/package", method = RequestMethod.GET)
    public @ResponseBody List<Shipment> getUserPackages() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Shipment> userPackages = getShipmentService().getAllPackagesForUser(userName);
        return userPackages;
    }
    
    @RequestMapping(value = "/package/{id}/packageStatus", method = RequestMethod.GET)
    public @ResponseBody List<PackageStatus> getPackageStatusesForPAckageWithId(@PathVariable("id") String id) {
        List<PackageStatus> packageStatuses = getPackageStatusService().getAllWithPackageId(Integer.valueOf(id));
        return packageStatuses;
    }
    
    @RequestMapping(value = "/myData", method = RequestMethod.GET)
    public @ResponseBody User getCurrentUserData() {
        User userWithId = getUserService().getUserByName(SecurityContextHolder.getContext().getAuthentication().getName());
        return userWithId;
    }
    
    @RequestMapping(value = "/get/{name}", method = RequestMethod.GET)
    public @ResponseBody User getUserWithId(@PathVariable("name") String name) {
        User userWithName = getUserService().getUserByName(name);
        return userWithName;
    }
    
    @RequestMapping(value = "/update/{name}", method = RequestMethod.PUT)
    public @ResponseBody void updateUserWithId(@PathVariable("name") String name,@RequestBody UserInfo userInfo) {
        //todo
        User userWithName = getUserService().getUserByName(name);
        getUserInfoService().updateUserInfo(userInfo);
        userWithName.setUserInfo(userInfo);

    }
    
    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public @ResponseBody void changeUserPassword(@RequestBody HashMap<String,Object> map ){
        getUserService().changePassword(map);
    }
    
}
