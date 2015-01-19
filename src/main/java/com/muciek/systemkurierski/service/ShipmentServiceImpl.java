/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.ShipmentDao;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.User;
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
        
        getShipmentDao().add(shipment);
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
}
