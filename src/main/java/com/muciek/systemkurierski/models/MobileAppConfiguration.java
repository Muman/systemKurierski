/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import java.util.List;

/**
 *
 * @author Muman
 */
public class MobileAppConfiguration {
    
    private Courier courier;
    private List<String> avaliablePackageStatuses;
    private List<Track> tracks;

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<String> getAvaliablePackageStatuses() {
        return avaliablePackageStatuses;
    }

    public void setAvaliablePackageStatuses(List<String> avaliablePackageStatuses) {
        this.avaliablePackageStatuses = avaliablePackageStatuses;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}
