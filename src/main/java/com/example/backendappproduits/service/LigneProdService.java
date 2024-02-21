package com.example.backendappproduits.service;

import com.example.backendappproduits.models.LigneProduit;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface LigneProdService {

    List<LigneProduit> readCsvFile(MultipartFile file);

    void saveCsvList(List<LigneProduit> lpList);
}
