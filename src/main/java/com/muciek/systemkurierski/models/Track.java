/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Piotr Muciek
 */
@Entity
@Table(name = "tracks")
public class Track {

    private int id;
    private Courier courier;
    private Set<TrackPoint> trackPoints = new HashSet<>();
    private Date created;
    private boolean active;
    private String encodedPoyline;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    public int getId() {
        return id;
    }
    
    @Column(length = 10000,name = "encoded_polyline", nullable = false, updatable = true)
    public String getEncodedPoyline() {
        return encodedPoyline;
    }
    
    @OneToMany(mappedBy = "track", fetch = FetchType.EAGER)
    public Set<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
    
    @Column(name = "create_date", nullable = false, updatable = false)
    public Date getCreated() {
        return created;
    }
        
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "courier_id")
    public Courier getCourier() {
        return courier;
    }
    
    public void setEncodedPoyline(String encodedPoyline) {
        this.encodedPoyline = encodedPoyline;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
    
    public void setTrackPoints(Set<TrackPoint> trackPoints) {
        this.trackPoints = trackPoints;
    }
}
