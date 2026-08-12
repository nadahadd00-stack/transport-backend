package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Truck;
import com.tms.transportbackend.service.TruckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TruckController {

    private final TruckService truckService;

    public TruckController(TruckService truckService) {
        this.truckService = truckService;
    }

    @GetMapping("/trucks")
    public ResponseEntity<List<Truck>> getAllTrucks() {
        return ResponseEntity.ok(
            truckService.getAllTrucks()
        );
    }

    @GetMapping("/truck/{id}")
    public ResponseEntity<Truck> getTruckById(
        @PathVariable Long id
    ) {
        return ResponseEntity.ok(
            truckService.getTruckById(id)
        );
    }

    @PostMapping("/truck")
    public ResponseEntity<Truck> saveTruck(
        @RequestBody Truck truck
    ) {

        if (truck.getId() == null) {
            Truck createdTruck =
                truckService.createTruck(truck);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdTruck);
        }

        Truck updatedTruck =
            truckService.updateTruck(truck);

        return ResponseEntity.ok(updatedTruck);
    }

    @DeleteMapping("/truck/{id}")
    public ResponseEntity<Void> deleteTruck(
        @PathVariable Long id
    ) {
        truckService.deleteTruck(id);

        return ResponseEntity.noContent().build();
    }
}