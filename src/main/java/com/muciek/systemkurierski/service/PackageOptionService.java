/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.PackageOption;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface PackageOptionService {

    public void addPackageOption(PackageOption packageOption);

    public void deletePackageOption(PackageOption packageOption);

    public void updatePackageOption(PackageOption packageOption);

    public PackageOption getPackageOptionById(int id);

    public List<PackageOption> getAllPackageOptions();
}
