package com.tms.transportbackend.repository;

import com.tms.transportbackend.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository 
        extends JpaRepository<Notification, Long> {

}