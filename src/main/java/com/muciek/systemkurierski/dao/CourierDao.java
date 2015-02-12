/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Courier;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface CourierDao {
    public void add(Courier courier);

    public void delete(Courier courier);

    public void update(Courier courier);

    public Courier getById(int id);
    
    public Courier getCourierByLogin(String login);
    
    public List<Courier> getAll();
}
