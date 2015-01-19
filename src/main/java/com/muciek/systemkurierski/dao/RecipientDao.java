/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.dao;

import com.muciek.systemkurierski.models.Recipient;
import java.util.List;

/**
 *
 * @author Muman
 */
public interface RecipientDao {
    public void add(Recipient recipient);

    public void delete(Recipient recipient);

    public void update(Recipient recipient);

    public Recipient getById(int id);

    public List<Recipient> getAll();
}
