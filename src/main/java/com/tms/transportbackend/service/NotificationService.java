package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Notification;
import com.tms.transportbackend.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;


    public NotificationService(NotificationRepository repository){
        this.repository = repository;
    }


    public List<Notification> getAll(){
        return repository.findAll();
    }


    public Notification getById(Long id){
        return repository.findById(id).orElse(null);
    }


    public Notification save(Notification notification){
        return repository.save(notification);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }
}