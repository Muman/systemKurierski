/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "track_points")
public class TrackPoint implements Serializable{

    private int id;
    private int orderIndex;
    private double longitude;
    private double latitude;
    private boolean visited;
    private String pathToNextPoint;
    private Track track;
    private Set<Shipment> shipments = new HashSet<>();

    @Column(name = "order_index",nullable = false,updatable = true)
    public int getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(int orderIndex) {
        this.orderIndex = orderIndex;
    }
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "TrackPoint_Shipment",
            joinColumns = {
                @JoinColumn(name = "trackPoint_id")},
            inverseJoinColumns = {
                @JoinColumn(name = "shipment_id")})
    @JsonIgnore
    public Set<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(Set<Shipment> shipments) {
        this.shipments = shipments;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "visited",nullable = false,updatable = true)
    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
    
    @Column(name = "longitude", nullable = false, unique = false)
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Column(name = "latitude", nullable = false, unique = false)
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Column(length = 10000, name = "path_to_next_point", nullable = false, unique = false)
    public String getPathToNextPoint() {
        return pathToNextPoint;
    }

    public void setPathToNextPoint(String pathToNextPoint) {
        this.pathToNextPoint = pathToNextPoint;
    }

    @ManyToOne
    @JoinColumn(name = "track_id")
    @JsonIgnore
    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }
}
