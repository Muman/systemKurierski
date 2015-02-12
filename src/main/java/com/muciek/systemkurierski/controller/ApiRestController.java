/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.MobileAppConfiguration;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.service.CourierAuthenticateService;
import com.muciek.systemkurierski.service.CourierService;
import com.muciek.systemkurierski.service.LocationService;
import com.muciek.systemkurierski.service.MobileAppConfigurationService;
import com.muciek.systemkurierski.service.PackageOptionService;
import com.muciek.systemkurierski.service.PackageStatusService;
import com.muciek.systemkurierski.service.RecipientService;
import com.muciek.systemkurierski.service.ShipmentService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import scala.util.parsing.json.JSONObject;

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
    
    @Autowired
    private CourierAuthenticateService courierAuthenticateService;
    
    @Autowired
    private MobileAppConfigurationService mobileAppConfigurationService;

    public MobileAppConfigurationService getMobileAppConfigurationService() {
        return mobileAppConfigurationService;
    }

    public void setMobileAppConfigurationService(MobileAppConfigurationService mobileAppConfigurationService) {
        this.mobileAppConfigurationService = mobileAppConfigurationService;
    }

    public CourierAuthenticateService getCourierAuthenticateService() {
        return courierAuthenticateService;
    }

    public void setCourierAuthenticateService(CourierAuthenticateService courierAuthenticateService) {
        this.courierAuthenticateService = courierAuthenticateService;
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
    
    @RequestMapping(value = "/locations", method = RequestMethod.GET )
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
    
    @RequestMapping("/shipments")
    public List<Shipment> getAllShipments(){
        return getShipmentService().getAll();
    }
    
    @RequestMapping("/shipments/{id}")
    public Shipment getShipmentWithId(@PathVariable("id") String id){
        return getShipmentService().getById(Integer.valueOf(id));
    }
    
    @RequestMapping(value = "/shipments/{id}/shipmentStatuses", method = RequestMethod.GET)
    public List<PackageStatus> getAllShipmentStatusesForShipmentWithId(@PathVariable("id") String id){
        List<PackageStatus> packageStatses = getPackageStatusService().getAllWithPackageId(Integer.valueOf(id));
        return packageStatses;
    }
    
    @RequestMapping(value = "/shipments/{id}/shipmentStatuses", method = RequestMethod.POST)
    public void addShipmentStatusesForShipmentWithId(@PathVariable("id") String id,@RequestBody PackageStatus packageStatus){
        getPackageStatusService().add(packageStatus);
    }
    
    @RequestMapping("/shipments/{shipmentId}/shipmentStatuses/{id}")
    public PackageStatus getShipmentStatusWithId(@PathVariable("id") String id,@PathVariable("shipmentId") String shipmentId){
        PackageStatus packageStatus = getPackageStatusService().getById(Integer.valueOf(id));
        return packageStatus;
    }
    
    @RequestMapping(value = "/authenticateCourier" , method = RequestMethod.POST)
    public Map<String,Object> authenticateCourier(@RequestBody HashMap<String,Object> credentialsMap){
        
        if(null != credentialsMap){
            String login = (String)credentialsMap.get("login");
            String password = (String)credentialsMap.get("password");
        
            boolean userAuthenticated = getCourierAuthenticateService().authenticateCourier(login, password);
            
            if(userAuthenticated){
                
                MobileAppConfiguration appConfig = 
                        getMobileAppConfigurationService().getAppConfigForCourier(getCourierService().getCourierByLogin(login));
                
                Map<String,Object> responseMap = new HashMap<>();
                responseMap.put("response","true");
                responseMap.put("appConfig",appConfig);
                
                return responseMap;
            }
        }
        
        throw new ResourceNotFoundException();
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
            
    }
}
