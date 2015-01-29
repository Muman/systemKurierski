/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.ShipmentDao;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.utils.DatabaseUtils;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentDao shipmentDao;

    @Autowired
    private RecipientService recipientService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private PackageStatusService packageStatusService;
    
    @Autowired
    private LocationService locationService;

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public PackageStatusService getPackageStatusService() {
        return packageStatusService;
    }

    public void setPackageStatusService(PackageStatusService packageStatusService) {
        this.packageStatusService = packageStatusService;
    }
    
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    
    public RecipientService getRecipientService() {
        return recipientService;
    }

    public void setRecipientService(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    public ShipmentDao getShipmentDao() {
        return shipmentDao;
    }

    public void setShipmentDao(ShipmentDao shipmentDao) {
        this.shipmentDao = shipmentDao;
    }

    @Override
    public void add(Shipment shipment) {
        
        Recipient recipient = shipment.getRecipient();
        getRecipientService().add(recipient);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        
        User user = getUserService().getUserByName(userName);

        Shipment newShipment = shipment;
        newShipment.setRecipient(recipient);
        newShipment.setUser(user);
        newShipment.setRegisterDate(new Date());
        
        getShipmentDao().add(shipment);
        
        Location statusLocation = getLocationService().getByName(DatabaseUtils.BASE_LOCATION_NAME);
        
        PackageStatus packageStatus = new PackageStatus();
        
        packageStatus.setName(PackageStatus.Type.READY_FOR_KURIERX.getStatus());
        packageStatus.setShipment(newShipment);
        packageStatus.setLocation(statusLocation);
        packageStatus.setStatusDate(new Date());
        
        getPackageStatusService().add(packageStatus);   
    }

    @Override
    public void delete(Shipment shipment) {
        getShipmentDao().delete(shipment);
    }

    @Override
    public void update(Shipment shipment) {
        getShipmentDao().update(shipment);
    }

    @Override
    public Shipment getById(int id) {
        return getShipmentDao().getById(id);
    }

    @Override
    public List<Shipment> getAll() {
        return getShipmentDao().getAll();
    }

    @Override
    public List<Shipment> getAllPackagesForUser(String username) {
        return getShipmentDao().getAllPackagesForUser(username);
    }
}
