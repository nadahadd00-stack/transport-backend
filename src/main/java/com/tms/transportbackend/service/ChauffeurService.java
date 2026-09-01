package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Chauffeur;
import com.tms.transportbackend.repository.ChauffeurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChauffeurService {

    private final ChauffeurRepository chauffeurRepository;

    public ChauffeurService(ChauffeurRepository chauffeurRepository) {
        this.chauffeurRepository = chauffeurRepository;
    }


    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }


    public Optional<Chauffeur> getChauffeurById(Long id) {
        return chauffeurRepository.findById(id);
    }


    public Chauffeur createChauffeur(Chauffeur chauffeur) {
        return chauffeurRepository.save(chauffeur);
    }


    public Chauffeur updateChauffeur(Long id, Chauffeur chauffeurDetails) {

        Chauffeur chauffeur = chauffeurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));


        chauffeur.setFirstName(chauffeurDetails.getFirstName());
        chauffeur.setLastName(chauffeurDetails.getLastName());
        chauffeur.setPhone(chauffeurDetails.getPhone());
        chauffeur.setEmail(chauffeurDetails.getEmail());
        chauffeur.setLicenseNumber(chauffeurDetails.getLicenseNumber());
        chauffeur.setHireDate(chauffeurDetails.getHireDate());
        chauffeur.setTruckId(chauffeurDetails.getTruckId());
        chauffeur.setStatus(chauffeurDetails.getStatus());


        return chauffeurRepository.save(chauffeur);
    }


    public void deleteChauffeur(Long id) {
        chauffeurRepository.deleteById(id);
    }
}