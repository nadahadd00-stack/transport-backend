package com.tms.transportbackend.repository;

import com.tms.transportbackend.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Truck, Long> {

    boolean existsByRegistrationNumber(String registrationNumber);
}