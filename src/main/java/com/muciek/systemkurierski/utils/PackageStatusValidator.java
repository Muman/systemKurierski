/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.utils;

import com.muciek.systemkurierski.models.PackageStatus;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**
 *
 * @author Muman
 */
@Component
public class PackageStatusValidator {
    
    private static PackageStatusValidator instance = null;
    
    private Map<String,List<String>> validationRules;
    
    private PackageStatusValidator(){
        initValidator();
    }
    
    public static PackageStatusValidator getInstance(){
        if(null == instance){
            instance = new PackageStatusValidator();
        }
        
        return instance;
    }
    
    @PostConstruct
    private void initValidator(){
        validationRules = new HashMap<String,List<String>>();
        
        List<String> RECIPIENT_ABSENT_rules = Arrays.asList(PackageStatus.Type.INITIATED.getStatus());
        List<String> READY_FOR_KURIERX_rules = Arrays.asList(PackageStatus.Type.RECEPTION_SCAN.getStatus());
        List<String> INITIATED_rules = Arrays.asList(PackageStatus.Type.RECEPTION_SCAN.getStatus());
        List<String> INITIAL_STATUS_rules = Arrays.asList(PackageStatus.Type.READY_FOR_KURIERX.getStatus(),
                PackageStatus.Type.INITIATED.getStatus());
        
        validationRules.put(PackageStatus.Type.RECIPIENT_ABSENT.getStatus(), RECIPIENT_ABSENT_rules);
        validationRules.put(PackageStatus.Type.READY_FOR_KURIERX.getStatus(), READY_FOR_KURIERX_rules);
        validationRules.put(PackageStatus.Type.INITIATED.getStatus(), INITIATED_rules);
        validationRules.put(null, INITIATED_rules);
    }
    
    public boolean validate(PackageStatus lastStatus, PackageStatus newStatus){
        
        if(null == newStatus)
            return false;
        
        String newStatusName = newStatus.getName();
        List<String> correctStatuses = null;
        
        if(null == lastStatus){
            correctStatuses = getValidationRules().get(null);
        }
        else{
            correctStatuses = getValidationRules().get(lastStatus.getName());
        }
        
        if(null == correctStatuses){
            return false;
        }
        else{
            return correctStatuses.contains(newStatusName);
        }
    }

    public Map<String, List<String>> getValidationRules() {
        return validationRules;
    }

    public void setValidationRules(Map<String, List<String>> validationRules) {
        this.validationRules = validationRules;
    }
}
