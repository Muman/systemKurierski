/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.UserDao;
import com.muciek.systemkurierski.dao.UserInfoDao;
import com.muciek.systemkurierski.dao.UserRoleDAO;
import com.muciek.systemkurierski.models.NewUserWrapper;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.models.UserInfo;
import com.muciek.systemkurierski.models.UserRole;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class RegisterServiceImpl implements RegisterService{

    @Autowired
    private UserRoleDAO userRoleDAO;
    
    @Autowired  
    private UserDao userDao;
    
    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }
    
    public UserRoleDAO getUserRoleDAO() {
        return userRoleDAO;
    }

    public void setUserRoleDAO(UserRoleDAO userRoleDao) {
        this.userRoleDAO = userRoleDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void register(NewUserWrapper newUserWrapper) {
        
        //create new UserInfo object
        UserInfo userInfo = newUserWrapper.getUserInfo();
        
        //save user Info
        getUserInfoDao().addUserInfo(userInfo);
        
        //create newUser object
        User newUser = newUserWrapper.getUser();
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        newUser.setUserInfo(userInfo);
        getUserDao().addUser(newUser);
        
                //create userRole
        UserRole userRole = new UserRole(newUser, UserRole.USER_ROLE.ROLE_USER.toString());
        getUserRoleDAO().addUserRole(userRole);
        
    }
}
