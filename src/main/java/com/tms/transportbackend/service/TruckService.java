package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Truck;
import com.tms.transportbackend.repository.TruckRepository;
import org.springframework.stereotype.Service;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public Truck createTruck(Truck truck) {
        boolean registrationExists =
            truckRepository.existsByRegistrationNumber(
                truck.getRegistrationNumber()
            );

        if (registrationExists) {
            throw new IllegalArgumentException(
                "Un camion avec cette immatriculation existe déjà."
            );
        }

        return truckRepository.save(truck);
    }
}