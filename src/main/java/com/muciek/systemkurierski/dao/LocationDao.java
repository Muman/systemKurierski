/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Location;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface LocationDao {
    public void add(Location location);

    public void delete(Location location);

    public void update(Location location);

    public Location getById(int id);

    public List<Location> getAll();
}
