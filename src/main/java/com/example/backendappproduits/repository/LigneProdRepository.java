package com.example.backendappproduits.repository;

import com.example.backendappproduits.models.LigneProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneProdRepository extends JpaRepository<LigneProduit, Long> {
}
