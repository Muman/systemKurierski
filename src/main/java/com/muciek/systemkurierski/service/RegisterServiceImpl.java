/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.UserDao;
import com.muciek.systemkurierski.dao.UserRoleDAO;
import com.muciek.systemkurierski.models.User;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void register(User user) {
       //check if username is not used
        
       //check if email is not already used
    }
    
}
