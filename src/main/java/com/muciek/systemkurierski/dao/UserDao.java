/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.User;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface UserDao {
    public User findByUserName(String username);
    
    public void addUser(User newUser);
    
    public List<User> getAllUsers();
    
    public List<User> getAllActiveUsers();
    
    public void deleteUser(User user);

    public void updateUser(User user);
}
