/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.UserInfo;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface UserInfoDao {
    public void addUserInfo(UserInfo userInfo);

    public void deleteUserInfo(UserInfo userInfo);

    public void updateUserInfo(UserInfo userInfo);

    public UserInfo getUserInfoById(int id);

    public List<UserInfo> getAllUserInfos();
}
