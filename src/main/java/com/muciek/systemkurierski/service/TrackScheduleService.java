/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.muciek.systemkurierski.service;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.DirectionsStep;
import com.google.maps.model.TravelMode;
import com.muciek.systemkurierski.models.Courier;
import com.muciek.systemkurierski.models.Location;
import com.muciek.systemkurierski.models.Recipient;
import com.muciek.systemkurierski.models.Shipment;
import com.muciek.systemkurierski.models.Track;
import com.muciek.systemkurierski.models.TrackPoint;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Muman
 */
@Service
@Transactional
public class TrackScheduleService {

    private static final int MAX_SHIPMENTS_COUNT = 8;
    private static final int BEST_ROUTE_INDEX = 0;

    @Autowired
    private ShipmentService shipmentService;

    @Autowired
    private CourierService courierService;

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

    public List<Track> generateTracksForLocation(Location location) {
        List<Track> createdTracks = new ArrayList<Track>();

        if (null == location) {
            throw new NullPointerException("location null");
        }

        //get All shipments that need to be scheduled for given location
        List<Shipment> shipmentsToSchedule = shipmentService.getAllShipmentsReadyToScheduleForLocation(location);

        //group shipments
        List<List<Shipment>> shipmentsGroups = groupShipmentsToDispatchForCouriers(shipmentsToSchedule);

        //get all couriers working in location to whom we can dispactch tracks
        //List<Courier> couriersInLocation = courierService.getAllCouriersForLocation(location);
        //create tracks
        for (List<Shipment> shipmentsGroup : shipmentsGroups) {
            // for each group of shipmnents create track
            Courier courier = getFreeCourierForTrack();
            //create Track
            Track newTrack = createTrack(shipmentsGroup, location, courier);
            createdTracks.add(newTrack);
            getTrackService().add(newTrack);
        }

        return createdTracks;
    }

    private Track createTrack(final List<Shipment> shipments, Location baseLocation, Courier courier) {
        Track newTrack = new Track();
        Set<TrackPoint> trackPointsForTrack = new HashSet<TrackPoint>();
        newTrack.setCourier(courier);

        // send request to GoogleDirections API and receive response
        DirectionsRoute[] response = getRoutesFromGoogleDirectionsApi(shipments, baseLocation);

        int[] waypointOrder = response[BEST_ROUTE_INDEX].waypointOrder;

        for (int i = 0; i < waypointOrder.length; ++i) {
            //get order of shipment
            int trackPointOrderIndex = getOrderIndexFromWaypointsOrder(i,waypointOrder);
            DirectionsLeg directionsLeg = response[BEST_ROUTE_INDEX].legs[trackPointOrderIndex];
            
            Shipment shipment = shipments.get(i);
            Set<Shipment> shipmentsForTrackPoint = new HashSet<Shipment>();  //todo: we should group shipments that have the same address!
            shipmentsForTrackPoint.add(shipment);                        // otherwise if we have N shiments for one addresss we user one waypoint for each so it is a huge wayste

            String pathToNextPoint = buildPathToNextPoint(directionsLeg);
            
            TrackPoint newTrackPoint = new TrackPoint();
            newTrackPoint.setTrack(newTrack);
            newTrackPoint.setLatitude(directionsLeg.endLocation.lat);
            newTrackPoint.setLongitude(directionsLeg.endLocation.lng);
            newTrackPoint.setVisited(false);
            newTrackPoint.setPathToNextPoint(pathToNextPoint);
            newTrackPoint.setShipments(shipmentsForTrackPoint);
            newTrackPoint.setOrderIndex(trackPointOrderIndex);
            
            trackPointService.add(newTrackPoint);
            trackPointsForTrack.add(newTrackPoint);
        }

        newTrack.setCreated(new Date());
        newTrack.setTrackPoints(trackPointsForTrack);
        newTrack.setActive(true);
        newTrack.setEncodedPoyline(response[BEST_ROUTE_INDEX].overviewPolyline.getEncodedPath());

        return newTrack;
    }
    
    private int getOrderIndexFromWaypointsOrder(int passedWaypointOrderIndex, int[] returnedWaypointsOrder){
        if(null == returnedWaypointsOrder || 0 == returnedWaypointsOrder.length){
            throw new IllegalArgumentException();
        }
        
        for(int i=0; i<returnedWaypointsOrder.length; ++i){
            if(returnedWaypointsOrder[i] == passedWaypointOrderIndex){
                return i;
            }
        }
        
        throw new IllegalArgumentException();
    }

    private DirectionsRoute[] getRoutesFromGoogleDirectionsApi(List<Shipment> shipments, Location baseLocation) {
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyAz_NDFLaF-UdP02pXF1nMRsz4JuY8TJkA");

        DirectionsApiRequest directionsApiRequest = DirectionsApi.newRequest(context);
        directionsApiRequest.origin(baseLocation.buildFullAddress());
        directionsApiRequest.destination(baseLocation.buildFullAddress());

        List<String> waypoints = getWaypointsFromShipments(shipments);
        String[] waypointsArray = waypoints.toArray(new String[waypoints.size()]);
        
        directionsApiRequest.optimizeWaypoints(true);
        directionsApiRequest.waypoints(waypointsArray);
        directionsApiRequest.mode(TravelMode.DRIVING);
        DirectionsRoute[] routes = null;

        try {
            routes = directionsApiRequest.await();
        } catch (Exception ex) {
            Logger.getLogger(TrackScheduleService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return routes;
    }

    private List<String> getWaypointsFromShipments(List<Shipment> shipments) {

        List<String> resultlist = new ArrayList<>();

        for (Shipment shipment : shipments) {
            Recipient recipient = shipment.getRecipient();
            resultlist.add(recipient.buildFullAddress());
        }

        return resultlist;
    }

    private List<List<Shipment>> groupShipmentsToDispatchForCouriers(List<Shipment> shipments) {
        List<List<Shipment>> groupsOfShipments = new ArrayList<List<Shipment>>();

        List<Shipment> newShipmentsList = new ArrayList<>();

        for (int i = 1; i <= shipments.size(); ++i) {
            newShipmentsList.add(shipments.get(i - 1));

            if (i % MAX_SHIPMENTS_COUNT == 0 || shipments.size() == i) {
                groupsOfShipments.add(newShipmentsList);
                newShipmentsList = new ArrayList<>();
            }
        }

        return groupsOfShipments;
    }

    private Courier getFreeCourierForTrack() {
        Courier testCourier = courierService.getCourierById(2);
        return testCourier;
    }

    private String buildPathToNextPoint(DirectionsLeg directionsLeg) {
        StringBuilder sb = new StringBuilder();
        
        for(DirectionsStep step : directionsLeg.steps){
            sb.append(step.polyline.getEncodedPath());
        }
        
        return sb.toString();
    }
}
