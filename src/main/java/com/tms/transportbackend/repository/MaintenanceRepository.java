package com.tms.transportbackend.repository;

import com.tms.transportbackend.entity.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository 
        extends JpaRepository<Maintenance, Long> {

}