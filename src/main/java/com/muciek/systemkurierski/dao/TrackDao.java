/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Track;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface TrackDao {
    public void add(Track track);

    public void delete(Track track);

    public void update(Track track);

    public Track getById(int id);
    
    public List<Track> getByCourier(Courier courier);
    
    public List<Track> getAll();
}
