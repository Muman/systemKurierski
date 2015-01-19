/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.PackageOption;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface PackageOptionDao {

    public void add(PackageOption packageOption);

    public void delete(PackageOption packageOption);

    public void update(PackageOption packageOption);

    public PackageOption getById(int id);

    public List<PackageOption> getAll();
}
