/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.TrackPointDao;
import com.muciek.systemkurierski.models.TrackPoint;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class TrackPointServiceImpl implements TrackPointService {

    @Autowired
    private TrackPointDao trackPointDao;

    public TrackPointDao getTrackPointDao() {
        return trackPointDao;
    }

    public void setTrackPointDao(TrackPointDao trackPointDao) {
        this.trackPointDao = trackPointDao;
    }

    @Override
    public void add(TrackPoint trackPoint) {
        getTrackPointDao().add(trackPoint);
    }

    @Override
    public void delete(TrackPoint trackPoint) {
        getTrackPointDao().delete(trackPoint);
    }

    @Override
    public void update(TrackPoint trackPoint) {
        getTrackPointDao().update(trackPoint);
    }

    @Override
    public TrackPoint getById(int id) {
        return getTrackPointDao().getById(id);
    }
}
