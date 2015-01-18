/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @RequestMapping("/")
    public String getAdminView() {
        return "admin/index";
    }

    @RequestMapping("/locations")
    public String getLocationsView() {
        return "admin/partials/locations";
    }

    @RequestMapping("/packageOptions")
    public String getPackageOptionsView() {
        return "admin/partials/packageOptions";
    }

    @RequestMapping("/couriers")
    public String getCouriersView() {
        return "admin/partials/couriers";
    }

    @RequestMapping("/users")
    public String getUsersView() {
        return "admin/partials/users";
    }
}
