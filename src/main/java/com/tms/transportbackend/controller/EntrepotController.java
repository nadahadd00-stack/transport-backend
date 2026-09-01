package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Entrepot;
import com.tms.transportbackend.service.EntrepotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrepots")
@CrossOrigin(origins = "http://localhost:4200")
public class EntrepotController {

    private final EntrepotService entrepotService;

    public EntrepotController(EntrepotService entrepotService) {
        this.entrepotService = entrepotService;
    }


    // GET ALL ENTREPOTS
    @GetMapping
    public List<Entrepot> getAllEntrepots() {
        return entrepotService.getAllEntrepots();
    }


    // GET ENTREPOT BY ID
    @GetMapping("/{id}")
    public Entrepot getEntrepotById(@PathVariable Long id) {
        return entrepotService.getEntrepotById(id)
                .orElseThrow(() -> new RuntimeException("Entrepot introuvable"));
    }


    // CREATE ENTREPOT
    @PostMapping
    public Entrepot createEntrepot(@RequestBody Entrepot entrepot) {
        return entrepotService.createEntrepot(entrepot);
    }


    // UPDATE ENTREPOT
    @PutMapping("/{id}")
    public Entrepot updateEntrepot(
            @PathVariable Long id,
            @RequestBody Entrepot entrepot) {

        return entrepotService.updateEntrepot(id, entrepot);
    }


    // DELETE ENTREPOT
    @DeleteMapping("/{id}")
    public String deleteEntrepot(@PathVariable Long id) {

        entrepotService.deleteEntrepot(id);

        return "Entrepot supprimé avec succès";
    }
}