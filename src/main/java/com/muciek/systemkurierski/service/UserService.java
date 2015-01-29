/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.User;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface UserService {
    public void addUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public User getUserByName(String name);

    public List<User> getAllUsers();
    
    public List<User> getAllActiveUsers();
    
    public void changePassword(HashMap<String, Object> map);
}
