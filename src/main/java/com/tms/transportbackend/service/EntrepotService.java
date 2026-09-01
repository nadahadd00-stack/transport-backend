package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Entrepot;
import com.tms.transportbackend.repository.EntrepotRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepotService {

    private final EntrepotRepository entrepotRepository;

    public EntrepotService(EntrepotRepository entrepotRepository) {
        this.entrepotRepository = entrepotRepository;
    }


    public List<Entrepot> getAllEntrepots() {
        return entrepotRepository.findAll();
    }


    public Optional<Entrepot> getEntrepotById(Long id) {
        return entrepotRepository.findById(id);
    }


    public Entrepot createEntrepot(Entrepot entrepot) {
        return entrepotRepository.save(entrepot);
    }


    public Entrepot updateEntrepot(Long id, Entrepot entrepotDetails) {

        Entrepot entrepot = entrepotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entrepot introuvable"));

        entrepot.setName(entrepotDetails.getName());
        entrepot.setAddress(entrepotDetails.getAddress());
        entrepot.setCity(entrepotDetails.getCity());
        entrepot.setCapacity(entrepotDetails.getCapacity());
        entrepot.setStatus(entrepotDetails.getStatus());

        return entrepotRepository.save(entrepot);
    }


    public void deleteEntrepot(Long id) {
        entrepotRepository.deleteById(id);
    }
}