package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Truck;
import com.tms.transportbackend.repository.TruckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TruckService {

    private final TruckRepository truckRepository;

    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public Truck getTruckById(Long id) {
        return truckRepository.findById(id)
            .orElseThrow(() ->
                new IllegalArgumentException(
                    "Camion introuvable avec l'id : " + id
                )
            );
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

    public Truck updateTruck(Truck truck) {

        if (truck.getId() == null) {
            throw new IllegalArgumentException(
                "L'id du camion est obligatoire pour la modification."
            );
        }

        Truck existingTruck =
            truckRepository.findById(truck.getId())
                .orElseThrow(() ->
                    new IllegalArgumentException(
                        "Camion introuvable avec l'id : "
                            + truck.getId()
                    )
                );

        existingTruck.setRegistrationNumber(
            truck.getRegistrationNumber()
        );
        existingTruck.setBrand(truck.getBrand());
        existingTruck.setModel(truck.getModel());
        existingTruck.setManufactureYear(
            truck.getManufactureYear()
        );
        existingTruck.setCapacity(truck.getCapacity());
        existingTruck.setFuelType(truck.getFuelType());
        existingTruck.setStatus(truck.getStatus());

        return truckRepository.save(existingTruck);
    }

    public void deleteTruck(Long id) {

        boolean truckExists =
            truckRepository.existsById(id);

        if (!truckExists) {
            throw new IllegalArgumentException(
                "Camion introuvable avec l'id : " + id
            );
        }

        truckRepository.deleteById(id);
    }
}