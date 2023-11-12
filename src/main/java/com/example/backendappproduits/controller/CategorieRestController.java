package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.service.CategorieService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "*")
//@Api(value = "API pour les catégories de produits")
public class CategorieRestController {

    @Autowired
    CategorieService catService;

    //@ApiOperation(value = "Récupère la liste des catégories")
    @GetMapping(value = "/all")
    public List<Categorie> getAllCategories() {
        return catService.getAllCat();
    }


    //@ApiOperation(value = "Récupère une catégorie par sin ID")
    @GetMapping(value = "/{id}")
    public Categorie getCategoryById(@PathVariable("id") Long id){ return catService.getCatById(id);}


    //@ApiOperation(value = "Crée une catégorie dans la base de données")
    @PostMapping(value = "/createCategorie")
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return catService.saveCategory(categorie);
    }

    //@ApiOperation(value = "Met à jour une catégorie dans la base de données")
    @PutMapping(value = "/updateCategory")
    public Categorie updateCategorie(@RequestBody Categorie cat) {
        return catService.updateCategory(cat);
    }

    //@ApiOperation(value = "Supprime une catégorie de la base de données")
    @DeleteMapping(value = "/deleteCategorie/{id}")
    public void deleteCategorie(@PathVariable("id") Long id){ catService.deleteCategoryById(id);}

}


