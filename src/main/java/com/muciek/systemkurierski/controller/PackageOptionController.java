/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.PackageOption;
import com.muciek.systemkurierski.service.PackageOptionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Muman
 */
@Controller
@RequestMapping("/packageOption")
public class PackageOptionController {
    
    @Autowired
    private PackageOptionService packageOptionService;

    public PackageOptionService getPackageOptionService() {
        return packageOptionService;
    }

    public void setPackageOptionService(PackageOptionService packageOptionService) {
        this.packageOptionService = packageOptionService;
    }
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody
    List<PackageOption> getAllPackageOptions() {
        return getPackageOptionService().getAllPackageOptions();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody
    void addPackageOption(@RequestBody PackageOption newPackageOption) {
        getPackageOptionService().addPackageOption(newPackageOption);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    void deletePackageOption(@RequestBody PackageOption packageOption) {
        getPackageOptionService().deletePackageOption(packageOption);
    }    

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    void updatePackageOption(@RequestBody PackageOption packageOption) {
        getPackageOptionService().updatePackageOption(packageOption);
    }    

    @RequestMapping(value = "/{id}")
    public @ResponseBody
    PackageOption getPackageOptionById(@PathVariable("id") String id) {
        PackageOption packageOption = getPackageOptionService().getPackageOptionById(Integer.valueOf(id));
        return packageOption;
    }

    @RequestMapping("/layout")
    public ModelAndView getPackageOptionPartialPage() {
        ModelAndView model = new ModelAndView();

        model.setViewName("packageOption/layout");
        return model;
    }
}
