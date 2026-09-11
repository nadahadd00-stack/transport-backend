package com.tms.transportbackend.repository;

import com.tms.transportbackend.entity.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison, Long> {

    List<Livraison> findAllByOrderByIdAsc();

}