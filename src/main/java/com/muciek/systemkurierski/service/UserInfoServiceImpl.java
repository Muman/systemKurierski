/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.UserInfoDao;
import com.muciek.systemkurierski.models.UserInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
    
    @Override
    public void addUserInfo(UserInfo userInfo) {
        getUserInfoDao().addUserInfo(userInfo);
    }

    @Override
    public void deleteUserInfo(UserInfo userInfo) {
        getUserInfoDao().deleteUserInfo(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        getUserInfoDao().updateUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return getUserInfoDao().getUserInfoById(id);
    }

    @Override
    public List<UserInfo> getAllUserInfos() {
        return getUserInfoDao().getAllUserInfos();
    }
}
