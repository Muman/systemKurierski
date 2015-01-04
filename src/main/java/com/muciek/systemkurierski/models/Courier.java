/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "couriers")
public class Courier {
    
    
    private int id;
    private String name;
    private String surname;
    private String pesel;
    private Date hireDate;
    private Date dismissDate;

    public Courier() {
    }

    public Courier(int id, String name, String surname, String pesel, Date hireDate, Date dismissDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.hireDate = hireDate;
        this.dismissDate = dismissDate;
    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false,unique = true)
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    @Column(name = "name",nullable = false,unique = false)
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    @Column(name = "surname",nullable = false,unique = false)
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the pesel
     */
    @Column(name = "pesel",nullable = false,unique = true,length = 11)
    public String getPesel() {
        return pesel;
    }

    /**
     * @param pesel the pesel to set
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * @return the hireDate
     */
    @Column(name = "hire_date",nullable = false,unique = false)
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    /**
     * @return the dismissDate
     */
    @Column(name = "dismiss_date",nullable = true,unique = false)
    public Date getDismissDate() {
        return dismissDate;
    }

    /**
     * @param dismissDate the dismissDate to set
     */
    public void setDismissDate(Date dismissDate) {
        this.dismissDate = dismissDate;
    }
}
