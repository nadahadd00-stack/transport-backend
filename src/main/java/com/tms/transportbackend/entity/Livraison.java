package com.tms.transportbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "LIVRAISONS")
public class Livraison {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String reference;

    private Long customerId;

    private Long truckId;

    private Long driverId;

    private Long warehouseId;

    private String destinationAddress;

    private String destinationCity;

    private Double cargoWeight;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime expectedArrival;

    private String status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }


    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }


    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }


    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }


    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }


    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }


    public Double getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(Double cargoWeight) {
        this.cargoWeight = cargoWeight;
    }


    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }


    public LocalDateTime getExpectedArrival() {
        return expectedArrival;
    }

    public void setExpectedArrival(LocalDateTime expectedArrival) {
        this.expectedArrival = expectedArrival;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}