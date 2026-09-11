package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Maintenance;
import com.tms.transportbackend.service.MaintenanceService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/maintenances")
@CrossOrigin(origins = "http://localhost:4200")
public class MaintenanceController {


    private final MaintenanceService service;


    public MaintenanceController(MaintenanceService service){
        this.service = service;
    }


    @GetMapping
    public List<Maintenance> getAll(){
        return service.getAll();
    }


    @GetMapping("/{id}")
    public Maintenance getById(
            @PathVariable Long id){

        return service.getById(id);
    }


    @PostMapping
    public Maintenance create(
            @RequestBody Maintenance maintenance){

        return service.save(maintenance);
    }


    @PutMapping("/{id}")
    public Maintenance update(
            @PathVariable Long id,
            @RequestBody Maintenance maintenance){

        maintenance.setId(id);

        return service.save(maintenance);
    }


    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id){

        service.delete(id);
    }

}