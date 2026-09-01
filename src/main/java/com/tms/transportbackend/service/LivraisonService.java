package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Livraison;
import com.tms.transportbackend.repository.LivraisonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivraisonService {

    private final LivraisonRepository livraisonRepository;

    public LivraisonService(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }


    public List<Livraison> getAllLivraisons() {
        return livraisonRepository.findAll();
    }


    public Optional<Livraison> getLivraisonById(Long id) {
        return livraisonRepository.findById(id);
    }


    public Livraison createLivraison(Livraison livraison) {
        return livraisonRepository.save(livraison);
    }


    public Livraison updateLivraison(Long id, Livraison livraisonDetails) {

        Livraison livraison = livraisonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livraison introuvable"));


        livraison.setReference(livraisonDetails.getReference());
        livraison.setCustomerId(livraisonDetails.getCustomerId());
        livraison.setTruckId(livraisonDetails.getTruckId());
        livraison.setDriverId(livraisonDetails.getDriverId());
        livraison.setWarehouseId(livraisonDetails.getWarehouseId());
        livraison.setDestinationAddress(livraisonDetails.getDestinationAddress());
        livraison.setDestinationCity(livraisonDetails.getDestinationCity());
        livraison.setCargoWeight(livraisonDetails.getCargoWeight());
        livraison.setDepartureDate(livraisonDetails.getDepartureDate());
        livraison.setExpectedArrival(livraisonDetails.getExpectedArrival());
        livraison.setStatus(livraisonDetails.getStatus());


        return livraisonRepository.save(livraison);
    }


    public void deleteLivraison(Long id) {
        livraisonRepository.deleteById(id);
    }
}