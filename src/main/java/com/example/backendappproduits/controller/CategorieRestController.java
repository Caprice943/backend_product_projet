package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieRestController {

    @Autowired
    CategorieRepository catRepo;

    @GetMapping(value = "/all")
    public List<Categorie> getAllCategories()
    {
        return catRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Categorie getCategorieById(@PathVariable("id") Long id) {
        return catRepo.findById(id).get();
    }

}
