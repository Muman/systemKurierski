/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.PackageStatus;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface PackageStatusService {
    public void add(PackageStatus packageStatus);

    public void delete(PackageStatus packageStatus);

    public void update(PackageStatus packageStatus);

    public PackageStatus getById(int id);

    public List<PackageStatus> getAll();
    
    public List<PackageStatus> getAllWithPackageId(int id);
    
    public PackageStatus getLastWithPackageId(int id);
}
