package com.example.backendappproduits.service;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService{

    @Autowired
    CategorieRepository catRepo;

    @Override
    public Categorie getCatById(Long id) {
        return catRepo.findById(id).get();
    }

    @Override
    public Categorie saveCategory(Categorie c) {
        return catRepo.save(c);
    }

    @Override
    public Categorie updateCategory(Categorie c) {
        return catRepo.save(c);
    }

    @Override
    public void deleteCategoryById(Long id) {
        catRepo.deleteById(id);
    }

    @Override
    public List<Categorie> getAllCat() {
        return catRepo.findAll();
    }
}
