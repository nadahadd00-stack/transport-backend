package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Livraison;
import com.tms.transportbackend.service.LivraisonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraisons")
@CrossOrigin(origins = "http://localhost:4200")
public class LivraisonController {

    private final LivraisonService livraisonService;

    public LivraisonController(LivraisonService livraisonService) {
        this.livraisonService = livraisonService;
    }


    @GetMapping
    public List<Livraison> getAllLivraisons() {
        return livraisonService.getAllLivraisons();
    }


    @GetMapping("/{id}")
    public Livraison getLivraisonById(@PathVariable Long id) {
        return livraisonService.getLivraisonById(id)
                .orElseThrow(() -> new RuntimeException("Livraison introuvable"));
    }


    @PostMapping
    public Livraison createLivraison(@RequestBody Livraison livraison) {
        return livraisonService.createLivraison(livraison);
    }


    @PutMapping("/{id}")
    public Livraison updateLivraison(
            @PathVariable Long id,
            @RequestBody Livraison livraison) {

        return livraisonService.updateLivraison(id, livraison);
    }


    @DeleteMapping("/{id}")
    public String deleteLivraison(@PathVariable Long id) {

        livraisonService.deleteLivraison(id);

        return "Livraison supprimée avec succès";
    }
}