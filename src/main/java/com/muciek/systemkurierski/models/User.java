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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "users")
public class User {

    private String username;
    private String password;
    private boolean enabled;

    @JsonIgnore
    private Set<UserRole> userRole = new HashSet<>(0);
    
    @JsonIgnore
    private Set<Shipment> shipment = new HashSet<>();

    private UserInfo userInfo;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_INFO_ID")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Id
    @Column(name = "username", unique = true,
            nullable = false, length = 45)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", nullable = false, length = 60)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Shipment> getShipment() {
        return shipment;
    }

    public void setShipment(Set<Shipment> shipment) {
        this.shipment = shipment;
    }
}
