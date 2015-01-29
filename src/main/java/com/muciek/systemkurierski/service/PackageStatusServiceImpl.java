/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.PackageStatusDao;
import com.muciek.systemkurierski.models.PackageStatus;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class PackageStatusServiceImpl implements PackageStatusService {

    @Autowired
    private PackageStatusDao packageStatusDao;

    public PackageStatusDao getPackageStatusDao() {
        return packageStatusDao;
    }

    public void setPackageStatusDao(PackageStatusDao packageStatusDao) {
        this.packageStatusDao = packageStatusDao;
    }

    @Override
    public void add(PackageStatus packageStatus) {
        getPackageStatusDao().add(packageStatus);
    }

    @Override
    public void delete(PackageStatus packageStatus) {
        getPackageStatusDao().delete(packageStatus);
    }

    @Override
    public void update(PackageStatus packageStatus) {
        getPackageStatusDao().update(packageStatus);
    }

    @Override
    public PackageStatus getById(int id) {
        return getPackageStatusDao().getById(id);
    }

    @Override
    public List<PackageStatus> getAll() {
        return getPackageStatusDao().getAll();
    }

    @Override
    public List<PackageStatus> getAllWithPackageId(int id) {
        return getPackageStatusDao().getAllWithPackageId(id);
    }

}
