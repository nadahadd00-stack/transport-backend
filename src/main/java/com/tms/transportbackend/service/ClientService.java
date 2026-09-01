package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Client;
import com.tms.transportbackend.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }


    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }


    public Client createClient(Client client) {
        return clientRepository.save(client);
    }


    public Client updateClient(Long id, Client clientDetails) {

        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client introuvable"));

        client.setName(clientDetails.getName());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());
        client.setAddress(clientDetails.getAddress());
        client.setCity(clientDetails.getCity());
        client.setStatus(clientDetails.getStatus());

        return clientRepository.save(client);
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}