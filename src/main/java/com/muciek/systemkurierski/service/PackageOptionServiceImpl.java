/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.PackageOptionDao;
import com.muciek.systemkurierski.models.PackageOption;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Transactional
@Service
public class PackageOptionServiceImpl implements PackageOptionService {

    @Autowired
    private PackageOptionDao packageOptionDao;

    public PackageOptionDao getPackageOptionDao() {
        return packageOptionDao;
    }

    public void setPackageOptionDao(PackageOptionDao packageOptionDao) {
        this.packageOptionDao = packageOptionDao;
    }

    @Override
    public void addPackageOption(PackageOption packageOption) {
        getPackageOptionDao().add(packageOption);
    }

    @Override
    public void deletePackageOption(PackageOption packageOption) {
        getPackageOptionDao().delete(packageOption);
    }

    @Override
    public void updatePackageOption(PackageOption packageOption) {
        getPackageOptionDao().update(packageOption);
    }

    @Override
    public PackageOption getPackageOptionById(int id) {
        return getPackageOptionDao().getById(id);
    }

    @Override
    public List<PackageOption> getAllPackageOptions() {
        return getPackageOptionDao().getAll();
    }

}
