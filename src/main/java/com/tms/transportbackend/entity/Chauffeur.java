package com.tms.transportbackend.entity;

import com.tms.transportbackend.enums.ChauffeurStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "CHAUFFEURS")
public class Chauffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String fullName;

    private String cin;

    private String phone;

    private String licenseNumber;

    private String category;

    private Integer experience;

    @Enumerated(EnumType.STRING)
    private ChauffeurStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public ChauffeurStatus getStatus() {
        return status;
    }

    public void setStatus(ChauffeurStatus status) {
        this.status = status;
    }
}