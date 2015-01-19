/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Shipment;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface ShipmentService {
    public void add(Shipment shipment);

    public void delete(Shipment shipment);

    public void update(Shipment shipment);

    public Shipment getById(int id);

    public List<Shipment> getAll();
}
