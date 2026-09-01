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
        livraison.setClientId(livraisonDetails.getClientId());
        livraison.setCamionId(livraisonDetails.getCamionId());
        livraison.setChauffeurId(livraisonDetails.getChauffeurId());
        livraison.setEntrepotId(livraisonDetails.getEntrepotId());
        livraison.setDestination(livraisonDetails.getDestination());
        livraison.setDeliveryDate(livraisonDetails.getDeliveryDate());
        livraison.setStatus(livraisonDetails.getStatus());

        return livraisonRepository.save(livraison);
    }


    public void deleteLivraison(Long id) {
        livraisonRepository.deleteById(id);
    }
}