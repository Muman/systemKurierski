package com.muciek.systemkurierski.controller;

import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.MobileAppConfiguration;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.Track;
import com.muciek.systemkurierski.models.TrackPoint;
import com.muciek.systemkurierski.service.CourierAuthenticateService;
import com.muciek.systemkurierski.service.CourierService;
import com.muciek.systemkurierski.service.LocationService;
import com.muciek.systemkurierski.service.MobileAppConfigurationService;
import com.muciek.systemkurierski.service.PackageOptionService;
import com.muciek.systemkurierski.service.PackageStatusService;
import com.muciek.systemkurierski.service.RecipientService;
import com.muciek.systemkurierski.service.ShipmentService;
import com.muciek.systemkurierski.service.TrackPointService;
import com.muciek.systemkurierski.service.TrackService;
import com.muciek.systemkurierski.utils.DatabaseUtils;
import com.muciek.systemkurierski.utils.PackageStatusValidator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import scala.util.parsing.json.JSONObject;

/**
 *
 * @author Muman
 */
@RestController
@RequestMapping("api/")
public class ApiRestController {
    
    @Autowired
    private LocationService locationService;
    
    @Autowired    
    private PackageOptionService packageOptionService;
    
    @Autowired    
    private CourierService courierService;
    
    @Autowired
    private ShipmentService shipmentService;
    
    @Autowired
    private PackageStatusService packageStatusService;
    
    @Autowired
    private RecipientService recipientService;
    
    @Autowired
    private CourierAuthenticateService courierAuthenticateService;
    
    @Autowired
    private MobileAppConfigurationService mobileAppConfigurationService;
    
    @Autowired
    private TrackService trackService;
    
    @Autowired
    private TrackPointService trackPointService;

    public TrackService getTrackService() {
        return trackService;
    }

    public void setTrackService(TrackService trackService) {
        this.trackService = trackService;
    }

    public TrackPointService getTrackPointService() {
        return trackPointService;
    }

    public void setTrackPointService(TrackPointService trackPointService) {
        this.trackPointService = trackPointService;
    }

    public MobileAppConfigurationService getMobileAppConfigurationService() {
        return mobileAppConfigurationService;
    }

    public void setMobileAppConfigurationService(MobileAppConfigurationService mobileAppConfigurationService) {
        this.mobileAppConfigurationService = mobileAppConfigurationService;
    }

    public CourierAuthenticateService getCourierAuthenticateService() {
        return courierAuthenticateService;
    }

    public void setCourierAuthenticateService(CourierAuthenticateService courierAuthenticateService) {
        this.courierAuthenticateService = courierAuthenticateService;
    }

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public PackageOptionService getPackageOptionService() {
        return packageOptionService;
    }

    public void setPackageOptionService(PackageOptionService packageOptionService) {
        this.packageOptionService = packageOptionService;
    }

    public CourierService getCourierService() {
        return courierService;
    }

    public void setCourierService(CourierService courierService) {
        this.courierService = courierService;
    }

    public ShipmentService getShipmentService() {
        return shipmentService;
    }

    public void setShipmentService(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    public PackageStatusService getPackageStatusService() {
        return packageStatusService;
    }

    public void setPackageStatusService(PackageStatusService packageStatusService) {
        this.packageStatusService = packageStatusService;
    }

    public RecipientService getRecipientService() {
        return recipientService;
    }

    public void setRecipientService(RecipientService recipientService) {
        this.recipientService = recipientService;
    }
    
    @RequestMapping(value = "/locations", method = RequestMethod.GET )
    public List<Location> getAllLocations(){
        return getLocationService().getAllLocations();
    }
    
    @RequestMapping("/locations/{id}")
    public Location getLocationById(@PathVariable("id") String id){
        return getLocationService().getLocationById(Integer.valueOf(id));
    }
    
    @RequestMapping("/couriers")
    public List<Courier> getAllCouriers(){
        return getCourierService().getAllCouriers();
    }
    
    @RequestMapping("/couriers/{id}")
    public Courier getCourierWithId(@PathVariable("id") String id){
        return getCourierService().getCourierById(Integer.valueOf(id));
    }
    
    @RequestMapping("/shipments")
    public List<Shipment> getAllShipments(){
        return getShipmentService().getAll();
    }
    
    @RequestMapping("/shipments/{id}")
    public Shipment getShipmentWithId(@PathVariable("id") String id){
        return getShipmentService().getById(Integer.valueOf(id));
    }
    
    @RequestMapping(value = "/shipments/{id}/shipmentStatuses", method = RequestMethod.GET)
    public List<PackageStatus> getAllShipmentStatusesForShipmentWithId(@PathVariable("id") String id){
        List<PackageStatus> packageStatses = getPackageStatusService().getAllWithPackageId(Integer.valueOf(id));
        return packageStatses;
    }
    
    @RequestMapping(value = "/shipments/{id}/shipmentStatuses", method = RequestMethod.POST)
    public Map<String,Object> addShipmentStatusesForShipmentWithId(@PathVariable("id") String id,@RequestBody Map<String,Object> params){
       
        PackageStatus newPackageStatus = buildShipmentStatus(params);
        
        if(null == newPackageStatus){
            throw new BadRequestException();
        }
        
        PackageStatus lastPackageStatus = getPackageStatusService().getLastWithPackageId(Integer.valueOf(id));
        
        boolean validationResult = PackageStatusValidator.getInstance().validate(lastPackageStatus, newPackageStatus);
        
        if(validationResult){  
            getPackageStatusService().add(newPackageStatus);
            
            Map<String,Object> result = new HashMap<>();
            result.put("status_name", newPackageStatus.getName());
            result.put("location_id", newPackageStatus.getLocation().getId());
            result.put("shipment_id", newPackageStatus.getShipment().getId());
            result.put("courier_id", newPackageStatus.getCourier().getId());
            result.put("shipment_status_id", newPackageStatus.getId());
            
            Shipment shipment = shipmentService.getById(Integer.valueOf(id));
            Set<TrackPoint> trackPoints = shipment.getTrackPoints();
            
            for(TrackPoint trackPoint:trackPoints){
                trackPoint.setVisited(true);
                trackPointService.update(trackPoint);
            }
            
            return result;
        }
        else{
            throw new BadRequestException();
        }
    }
    
    @RequestMapping(value = "/shipments/{shipmentId}/shipmentStatuses/{id}",method = RequestMethod.GET)
    public PackageStatus getShipmentStatusWithId(@PathVariable("id") String id,@PathVariable("shipmentId") String shipmentId){
        PackageStatus packageStatus = getPackageStatusService().getById(Integer.valueOf(id));
        return packageStatus;
    }

    @RequestMapping(value = "/shipments/{shipmentId}/shipmentStatuses/{id}",method = RequestMethod.PUT)
    public PackageStatus updateShipmentStatusWithId(@PathVariable("id") String id,@PathVariable("shipmentId") String shipmentId, @RequestBody PackageStatus packageStatus){
        getPackageStatusService().add(packageStatus);
        return packageStatus;
    }
    
    @RequestMapping(value = "/authenticateCourier" , method = RequestMethod.POST)
    public MobileAppConfiguration authenticateCourier(@RequestBody HashMap<String,Object> credentialsMap){
        
        if(null != credentialsMap){
            String login = (String)credentialsMap.get("login");
            String password = (String)credentialsMap.get("password");
        
            boolean userAuthenticated = getCourierAuthenticateService().authenticateCourier(login, password);
            
            if(userAuthenticated){
                MobileAppConfiguration appConfig = 
                        getMobileAppConfigurationService().getAppConfigForCourier(getCourierService().getCourierByLogin(login));
                return appConfig;
            }
        }
        
        throw new ResourceNotFoundException();
    }

    private PackageStatus buildShipmentStatus(Map<String, Object> params) {
        //get params 
        if(null == params){
            return null;
        }
        
        String statusName = (String)params.get(DatabaseUtils.STATUS_NAME);
        int locationId = (int)params.get(DatabaseUtils.LOCATION_ID);
        int courierId = (int)params.get(DatabaseUtils.COURIER_ID);
        int shipmentId = (int)params.get(DatabaseUtils.SHIPMENT_ID);
        
        if(null == statusName || statusName.isEmpty()){
            return null;
        }
        
        Courier courier = getCourierService().getCourierById(courierId);
        Shipment shipment = getShipmentService().getById(shipmentId);
        Location location = getLocationService().getLocationById(locationId);
        
        if(null != courier && null != shipment && null != location){
            PackageStatus newPackageStatus = new PackageStatus();
            newPackageStatus.setCourier(courier);
            newPackageStatus.setLocation(location);
            newPackageStatus.setShipment(shipment);
            newPackageStatus.setStatusDate(new Date());
            newPackageStatus.setName(statusName);
            
            return newPackageStatus;
        }
        
        return null;
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class ResourceNotFoundException extends RuntimeException {
        
    }
    
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public class BadRequestException extends RuntimeException {
        
    } 
    
    @RequestMapping("/couriers/{id}/tracks")
    public List<Track> getAllActiveTracksForCourier(@PathVariable("id") String courierId){
        Courier courier = getCourierService().getCourierById(Integer.valueOf(courierId));
        
        List<Track> courierTracks = getTrackService().getByCourier(courier);
        return courierTracks;
    }
    
//    @RequestMapping("/couriers/{courier_id}/tracks/{track_id}")
//    public Track getTrackForCourier(@PathVariable("courier_id") String courierId, @PathVariable("track_id") String trackId){
//        List<Track> courierTracks = getTrackService().getByCourier(courier);
//}
    @RequestMapping("/tracks")
    public List<Track> getAllTracks(){
        return getTrackService().getAll();
    }
    
    @RequestMapping("/tracks/{id}")
    public Track getTrackWithId(@PathVariable("id") String id){
        return getTrackService().getById(Integer.valueOf(id));
    }
}
