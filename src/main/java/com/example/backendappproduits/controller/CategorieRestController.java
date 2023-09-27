package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieRestController {

    @Autowired
    CategorieService catService;

    @GetMapping(value = "/all")
    public List<Categorie> getAllCategories() {
        return catService.getAllCat();
    }

    @PostMapping(value = "/createCategorie")
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return catService.saveCategory(categorie);
    }

    @PutMapping(value = "/updateCategory")
    public Categorie updateCategorie(@RequestBody Categorie cat) {
        return catService.updateCategory(cat);
    }

    @DeleteMapping(value = "/deleteCategorie/{id}")
    public void deleteCategorie(@PathVariable("id") Long id){ catService.deleteCategoryById(id);}

}


