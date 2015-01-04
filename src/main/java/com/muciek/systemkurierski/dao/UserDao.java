/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.User;

/**
 *
 * @author Muman
 */
public interface UserDao {
    User findByUserName(String username);
}
