package com.muciek.systemkurierski.service;

import com.muciek.systemkurierski.dao.ShipmentDao;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.PackageStatus;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.TrackPoint;
import com.muciek.systemkurierski.models.User;
import com.muciek.systemkurierski.utils.DatabaseUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentDao shipmentDao;

    @Autowired
    private RecipientService recipientService;

    @Autowired
    private UserService userService;

    @Autowired
    private PackageStatusService packageStatusService;

    @Autowired
    private LocationService locationService;

    public LocationService getLocationService() {
        return locationService;
    }

    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    public PackageStatusService getPackageStatusService() {
        return packageStatusService;
    }

    public void setPackageStatusService(PackageStatusService packageStatusService) {
        this.packageStatusService = packageStatusService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public RecipientService getRecipientService() {
        return recipientService;
    }

    public void setRecipientService(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    public ShipmentDao getShipmentDao() {
        return shipmentDao;
    }

    public void setShipmentDao(ShipmentDao shipmentDao) {
        this.shipmentDao = shipmentDao;
    }

    @Override
    public void add(Shipment shipment) {

        Recipient recipient = shipment.getRecipient();
        getRecipientService().add(recipient);

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = getUserService().getUserByName(userName);

        Shipment newShipment = shipment;
        newShipment.setRecipient(recipient);
        newShipment.setUser(user);
        newShipment.setRegisterDate(new Date());

        getShipmentDao().add(shipment);

        Location statusLocation = getLocationService().getByName(DatabaseUtils.BASE_LOCATION_NAME);

        PackageStatus packageStatus = new PackageStatus();

        packageStatus.setName(PackageStatus.Type.READY_FOR_KURIERX.getStatus());
        packageStatus.setShipment(newShipment);
        packageStatus.setLocation(statusLocation);
        packageStatus.setStatusDate(new Date());

        getPackageStatusService().add(packageStatus);
    }

    @Override
    public void delete(Shipment shipment) {
        getShipmentDao().delete(shipment);
    }

    @Override
    public void update(Shipment shipment) {
        getShipmentDao().update(shipment);
    }

    @Override
    public Shipment getById(int id) {
        return getShipmentDao().getById(id);
    }

    @Override
    public List<Shipment> getAll() {
        return getShipmentDao().getAll();
    }

    @Override
    public List<Shipment> getAllPackagesForUser(String username) {
        return getShipmentDao().getAllPackagesForUser(username);
    }

    /**
     * Get all shipemnts that are ready to be taken by courier from client or
     * magazine, shipments can't be in any other unfinished track
     *
     * @param location
     * @return
     */
    @Override
    public List<Shipment> getAllShipmentsReadyToScheduleForLocation(Location location) {

        List<Shipment> resultList = new ArrayList<Shipment>();

        //get ell shipments arrived to location
        List<Shipment> initiatedShipments = getAllShipmentsWithStatusFromLocation(PackageStatus.Type.PACKAGE_ARRIVED,location);

        // get all shiments assigned to location to be received by courier
        List<Shipment> readyForKurierxShipments = getAllShipmentsWithStatusFromLocation(PackageStatus.Type.READY_FOR_KURIERX,location);
        
        List<Shipment> shipmentsToTest = ListUtils.union(initiatedShipments, readyForKurierxShipments);
        
        //check each shipment if it's not contained in any unfinished track
        
        for(Shipment shipment : shipmentsToTest){
            boolean isShipmentOnAnyUnfinishedTrack = false;
            
            //check if shipments is related with any trackpoint
            if(null == shipment.getTrackPoints()){
                resultList.add(shipment);
                continue;
            }
            
            // check if shipment is related with any trackpoint that has not been visited
            for(TrackPoint trackPointForShipment : shipment.getTrackPoints()){
                if(false == trackPointForShipment.isVisited()){
                    isShipmentOnAnyUnfinishedTrack = true;
                    break;
                }
            }
            
            if(false == isShipmentOnAnyUnfinishedTrack){
                resultList.add(shipment);
            }
        }
        
        return resultList;
    }

    @Override
    public List<Shipment> getAllShipmentsWithStatus(PackageStatus.Type type) {
        List<Shipment> shipmentsWithStatus = new ArrayList<>();

        List<Shipment> allShipments = getShipmentDao().getAll();

        for (Shipment shipment : allShipments) {
            /**
             * get last status for package *
             */
            PackageStatus lastStatusForPackage = packageStatusService.getLastWithPackageId(shipment.getId());

            if (null != lastStatusForPackage && lastStatusForPackage.getName().equals(type.getStatus())) {
                shipmentsWithStatus.add(shipment);
            }
        }

        return shipmentsWithStatus;
    }

    @Override
    public List<Shipment> getAllShipmentsWithStatusFromLocation(PackageStatus.Type type, Location location) {
        List<Shipment> shipmentsWithStatus = new ArrayList<>();

        List<Shipment> allShipments = getShipmentDao().getAll();

        for (Shipment shipment : allShipments) {
            PackageStatus lastStatusForPackage = packageStatusService.getLastWithPackageId(shipment.getId());

            if (null != lastStatusForPackage 
                    && null != location
                    && lastStatusForPackage.getName().equals(type.getStatus())
                    && location.getId() == lastStatusForPackage.getLocation().getId()) {
                
                shipmentsWithStatus.add(shipment);
            }
        }

        return shipmentsWithStatus;
    }
}
