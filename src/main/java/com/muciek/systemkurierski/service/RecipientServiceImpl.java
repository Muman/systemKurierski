/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.RecipientDao;
import com.muciek.systemkurierski.models.Recipient;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class RecipientServiceImpl implements RecipientService {
    
    @Autowired
    private RecipientDao recipientDao;

    public RecipientDao getRecipientDao() {
        return recipientDao;
    }

    public void setRecipientDao(RecipientDao recipientDao) {
        this.recipientDao = recipientDao;
    }
    
    @Override
    public void add(Recipient recipient) {
        getRecipientDao().add(recipient);
    }

    @Override
    public void delete(Recipient recipient) {
        getRecipientDao().delete(recipient);
    }

    @Override
    public void update(Recipient recipient) {
        getRecipientDao().update(recipient);
    }

    @Override
    public Recipient getById(int id) {
        return getRecipientDao().getById(id);
    }

    @Override
    public List<Recipient> getAll() {
        return getRecipientDao().getAll();
    } 
}
