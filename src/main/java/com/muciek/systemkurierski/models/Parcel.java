/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import javax.persistence.Entity;

/**
 *
 * @author Muman
 */

public class Parcel {
    private int id;
    PackageOption packageType;
    PackageWeight packageWeight;
    
}
