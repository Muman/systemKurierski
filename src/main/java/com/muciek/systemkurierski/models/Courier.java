/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    private String email;
    private Date hireDate;
    private Date dismissDate;
    private String login;
    private String passwod;
    private Location location;
    private Set<Track> tracks = new HashSet<Track>();

//    public Courier() {
//    }
//
//    public Courier(int id, String name, String surname, String pesel, String email, Date hireDate, Date dismissDate) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.pesel = pesel;
//        this.email = email;
//        this.hireDate = hireDate;
//        this.dismissDate = dismissDate;
//    }
//
//    public Courier(int id, String name, String surname, String pesel, String email, Date hireDate, Date dismissDate, String login, String passwod, Location location) {
//        this.id = id;
//        this.name = name;
//        this.surname = surname;
//        this.pesel = pesel;
//        this.email = email;
//        this.hireDate = hireDate;
//        this.dismissDate = dismissDate;
//        this.login = login;
//        this.passwod = passwod;
//        this.location = location;
//    }

    /**
     * @return the id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name = "login", nullable = false, unique = true)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @JsonIgnore
    @Column(name = "password", nullable = false, unique = false)
    public String getPasswod() {
        return passwod;
    }

    public void setPasswod(String passwod) {
        this.passwod = passwod;
    }

    /**
     * @return the name
     */
    @Column(name = "name", nullable = false, unique = false)
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
    @Column(name = "surname", nullable = false, unique = false)
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
    @Column(name = "pesel", nullable = false, unique = true, length = 11)
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
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd" )
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD" )
    @Column(name = "hire_date", nullable = false, unique = false)
    public Date getHireDate() {
        return hireDate;
    }

    /**
     * @param hireDate the hireDate to set
     */
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the dismissDate
     */
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD" )
    @Column(name = "dismiss_date", nullable = true, unique = false)
    public Date getDismissDate() {
        return dismissDate;
    }

    /**
     * @param dismissDate the dismissDate to set
     */
//        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd" )
    public void setDismissDate(Date dismissDate) {
        this.dismissDate = dismissDate;
    }

    @ManyToOne
    @JoinColumn(name = "location_id")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "courier")
    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }
}
