package com.tms.transportbackend.service;

import com.tms.transportbackend.entity.Maintenance;
import com.tms.transportbackend.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {


    private final MaintenanceRepository repository;


    public MaintenanceService(MaintenanceRepository repository){
        this.repository = repository;
    }


    public List<Maintenance> getAll(){
        return repository.findAll();
    }


    public Maintenance getById(Long id){
        return repository.findById(id)
                .orElse(null);
    }


    public Maintenance save(Maintenance maintenance){
        return repository.save(maintenance);
    }


    public void delete(Long id){
        repository.deleteById(id);
    }

}