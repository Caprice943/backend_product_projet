package com.example.backendappproduits.service;

import com.example.backendappproduits.models.Categorie;

import java.util.List;

public interface CategorieService {

    Categorie getCatById( Long id);

    Categorie saveCategory( Categorie c);

    Categorie updateCategory( Categorie c);

     void deleteCategoryById(Long id);

    List<Categorie> getAllCat();




}
