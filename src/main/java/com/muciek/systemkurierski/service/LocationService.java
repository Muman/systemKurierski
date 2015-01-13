/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.Location;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface LocationService {

    public void addLocation(Location location);

    public void deleteLocation(Location location);

    public void updateLocation(Location location);

    public Location getLocationById(int id);

    public List<Location> getAllLocations();
}
