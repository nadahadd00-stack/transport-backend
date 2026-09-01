package com.tms.transportbackend.controller;

import com.tms.transportbackend.entity.Client;
import com.tms.transportbackend.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }


    @GetMapping("/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.getClientById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));
    }


    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }


    @PutMapping("/{id}")
    public Client updateClient(
            @PathVariable Long id,
            @RequestBody Client client) {

        return clientService.updateClient(id, client);
    }


    @DeleteMapping("/{id}")
    public String deleteClient(@PathVariable Long id) {

        clientService.deleteClient(id);

        return "Client supprimé avec succès";
    }
}