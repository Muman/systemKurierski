/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.LocationDao;
import com.muciek.systemkurierski.models.Location;
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
public class LocationServiceImpl implements LocationService{

    @Autowired
    private LocationDao locationDao;

    public LocationDao getLocationDao() {
        return locationDao;
    }

    public void setLocationDao(LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    
    @Override
    public void addLocation(Location location) {
        getLocationDao().add(location);
    }

    @Override
    public void deleteLocation(Location location) {
        getLocationDao().delete(location);
    }

    @Override
    public void updateLocation(Location location) {
        getLocationDao().update(location);
    }

    @Override
    public Location getLocationById(int id) {
        return getLocationDao().getById(id);
    }

    @Override
    public List<Location> getAllLocations() {
       return getLocationDao().getAll();
    }

    @Override
    public Location getByName(String name) {
        return getLocationDao().getByName(name);
    }
    
}
