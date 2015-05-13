/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.TrackPoint;

/**
 *
 * @author Muman
 */
public interface TrackPointService {
    public void add(TrackPoint trackPoint);

    public void delete(TrackPoint trackPoint);

    public void update(TrackPoint trackPoint);

    public TrackPoint getById(int id);
}
