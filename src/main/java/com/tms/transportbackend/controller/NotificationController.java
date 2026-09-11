package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Notification;
import com.tms.transportbackend.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {


    private final NotificationService service;


    public NotificationController(NotificationService service){
        this.service = service;
    }


    @GetMapping
    public List<Notification> getAll(){
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Notification getById(
            @PathVariable Long id){
        return service.getById(id);
    }


    @PostMapping
    public Notification add(
            @RequestBody Notification notification){
        return service.save(notification);
    }


    @PutMapping("/{id}")
    public Notification update(
            @PathVariable Long id,
            @RequestBody Notification notification){

        notification.setId(id);

        return service.save(notification);
    }


    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id){

        service.delete(id);
    }
}