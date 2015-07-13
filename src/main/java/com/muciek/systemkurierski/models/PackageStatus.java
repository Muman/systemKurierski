package com.muciek.systemkurierski.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Muman
 */
@Entity
@Table(name = "package_status")
public class PackageStatus implements Serializable {

    private int id;
    private String name;
    private Shipment shipment;
    private Courier courier;
    private Date statusDate;
    private Location location;
    private boolean active;

    public enum Type {
        
        READY_FOR_KURIERX("Oczekuje na odbiór przez KurierX"),
        COLLECTED("Odebrano od nadawcy"),
        PACKAGE_ARRIVED("Nadejscie przesy³ki"),
        RECIPIENT_ABSENT("Nieudane dorêczenie"),
        DELIVERED("Dostarczono do klienta");
        
        private String s;

        private Type(String s) {
            this.setStatus(s);
        }

        public void setStatus(String s) {
            this.s = s;
        }

        public String getStatus() {
            return s;
        }
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courier_id", nullable = true)
    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id", nullable = false)
    public Location getLocation() {
        return location;
    }
    
    @Column(nullable = false)
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "status_date", nullable = false)
    public Date getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(Date statusDate) {
        this.statusDate = statusDate;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipment_id", nullable = false)
    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }
}
