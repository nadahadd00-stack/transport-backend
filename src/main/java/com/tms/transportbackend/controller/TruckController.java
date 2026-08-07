package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Truck;
import com.tms.transportbackend.service.TruckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trucks")
@CrossOrigin(origins = "http://localhost:4200")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @PostMapping
    public ResponseEntity<Truck> createTruck(
        @RequestBody Truck truck
    ) {
        Truck createdTruck =
            truckService.createTruck(truck);

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdTruck);
    }
}