package com.tms.transportbackend.entity;

import com.tms.transportbackend.enums.FuelType;
import com.tms.transportbackend.enums.TruckStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "TRUCKS")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
        name = "REGISTRATION_NUMBER",
        nullable = false,
        unique = true
    )
    private String registrationNumber;

    @Column(
        name = "BRAND",
        nullable = false
    )
    private String brand;

    @Column(
        name = "MODEL",
        nullable = false
    )
    private String model;

    @Column(name = "MANUFACTURE_YEAR")
    private Integer manufactureYear;

    @Column(name = "CAPACITY")
    private Double capacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "FUEL_TYPE")
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private TruckStatus status;

    public Truck() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(
        String registrationNumber
    ) {
        this.registrationNumber =
            registrationNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(
        Integer manufactureYear
    ) {
        this.manufactureYear =
            manufactureYear;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public TruckStatus getStatus() {
        return status;
    }

    public void setStatus(TruckStatus status) {
        this.status = status;
    }
}