/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "locations")
public class Location {

    private int id;
    private String address;
    private String postalCode;
    private String city;
    private String name;
    private Set<Courier> couriers = new HashSet<Courier>();
    private Set<PackageStatus> packageStatuses = new HashSet<PackageStatus>();

    @JsonIgnore
    @OneToMany(mappedBy = "location" ,fetch = FetchType.EAGER)
    public Set<Courier> getCouriers() {
        return couriers;
    }

    public void setCouriers(Set<Courier> couriers) {
        this.couriers = couriers;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "location")
    public Set<PackageStatus> getPackageStatuses() {
        return packageStatuses;
    }

    public void setPackageStatuses(Set<PackageStatus> packageStatuses) {
        this.packageStatuses = packageStatuses;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "postal_code", nullable = false, unique = false, length = 10)
    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Column(name = "city", nullable = false, unique = false, length = 32)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "address", nullable = false, unique = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    /**
     * 
     * @return full address containing city name, street, and building number
     */
    public String buildFullAddress(){
        StringBuilder sb = new StringBuilder();
        sb.append(getAddress()).append(" ").append(getCity());
        return sb.toString();
    }
}
