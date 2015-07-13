/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.UserDao;
import com.muciek.systemkurierski.dao.UserRoleDAO;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.models.UserInfo;
import com.muciek.systemkurierski.models.UserRole;
import java.util.HashMap;
import java.util.List;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRoleDAO userRoleDAO;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {

        UserInfo userInfo = user.getUserInfo();
        getUserInfoService().addUserInfo(userInfo);

        User newUser = user;
        String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashedPassword);
        newUser.setUserInfo(userInfo);
        getUserDao().addUser(newUser);

        UserRole userRole = new UserRole(newUser, UserRole.USER_ROLE.ROLE_USER.toString());
        getUserRoleDAO().add(userRole);
    }

    @Override
    public void deleteUser(User user) {
        user.setActive(false);
        updateUser(user);
    }

    @Override
    public void updateUser(User user) {
        UserInfo userInfo = user.getUserInfo();
        getUserInfoService().updateUserInfo(userInfo);

        User newUser = user;
        newUser.setUserInfo(userInfo);
        getUserDao().updateUser(newUser);

        //todo update user role
//        UserRole userRole = new UserRole(newUser, UserRole.USER_ROLE.ROLE_USER.toString());
//        getUserRoleDAO().add(userRole);
    }

    @Override
    public User getUserByName(String name) {
        return getUserDao().findByUserName(name);
    }

    @Override
    public List<User> getAllUsers() {
        return getUserDao().getAllUsers();
    }

    @Override
    public List<User> getAllActiveUsers() {
        return getUserDao().getAllActiveUsers();
    }

    /**
     * @return the userInfoService
     */
    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    /**
     * @param userInfoService the userInfoService to set
     */
    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * @return the userRoleDAO
     */
    public UserRoleDAO getUserRoleDAO() {
        return userRoleDAO;
    }

    /**
     * @param userRoleDAO the userRoleDAO to set
     */
    public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
        this.userRoleDAO = userRoleDAO;
    }

    @Override
    public void changePassword(HashMap<String, Object> map) {

        // get data from map
        String username = (String) map.get("username");
        String newPassword = (String) map.get("password");

        // hash new password 
        newPassword = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        User userToUpdate = getUserByName(username);

        if (null != userToUpdate) {
            userToUpdate.setPassword(newPassword);
            updateUser(userToUpdate);
        }
    }

}
