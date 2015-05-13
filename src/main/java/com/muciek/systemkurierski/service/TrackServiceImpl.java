/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.TrackDao;
import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Track;
import java.util.ArrayList;
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
public class TrackServiceImpl implements TrackService {

    @Autowired
    private TrackDao TrackDao;

    @Autowired
    private TrackPointService trackPointService;

    public TrackPointService getTrackPointService() {
        return trackPointService;
    }

    public void setTrackPointService(TrackPointService trackPointService) {
        this.trackPointService = trackPointService;
    }
    
    public TrackDao getTrackDao() {
        return TrackDao;
    }

    public void setTrackDao(TrackDao TrackDao) {
        this.TrackDao = TrackDao;
    }
    
    @Override
    public void add(Track track) {
        getTrackDao().add(track);
    }

    @Override
    public void delete(Track track) {
        getTrackDao().delete(track);
    }

    @Override
    public void update(Track track) {
        getTrackDao().update(track);
    }

    @Override
    public Track getById(int id) {
        return getTrackDao().getById(id);
    }

    @Override
    public List<Track> getByCourier(Courier courier) {
        return getTrackDao().getByCourier(courier);
    }

    @Override
    public List<Track> getAll() {
        return getTrackDao().getAll();
    }
    
}
