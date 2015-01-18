/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.models.NewUserWrapper;
import com.muciek.systemkurierski.models.User;

/**
 *
 * @author Muman
 */
public interface RegisterService {
    public void register(NewUserWrapper newUserWrapper);
}
