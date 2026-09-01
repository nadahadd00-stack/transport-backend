package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Chauffeur;
import com.tms.transportbackend.service.ChauffeurService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chauffeurs")
@CrossOrigin(origins = "http://localhost:4200")
public class ChauffeurController {

    private final ChauffeurService chauffeurService;

    public ChauffeurController(ChauffeurService chauffeurService) {
        this.chauffeurService = chauffeurService;
    }


    @GetMapping
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurService.getAllChauffeurs();
    }


    @GetMapping("/{id}")
    public Chauffeur getChauffeurById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id)
                .orElseThrow(() -> new RuntimeException("Chauffeur introuvable"));
    }


    @PostMapping
    public Chauffeur createChauffeur(@RequestBody Chauffeur chauffeur) {
        return chauffeurService.createChauffeur(chauffeur);
    }


    @PutMapping("/{id}")
    public Chauffeur updateChauffeur(
            @PathVariable Long id,
            @RequestBody Chauffeur chauffeur) {

        return chauffeurService.updateChauffeur(id, chauffeur);
    }


    @DeleteMapping("/{id}")
    public String deleteChauffeur(@PathVariable Long id) {

        chauffeurService.deleteChauffeur(id);

        return "Chauffeur supprimé avec succès";
    }
}