package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.service.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "*")
@Tag(name = "CategorieController")
public class CategorieRestController {

    @Autowired
    CategorieService catService;

    @Operation(summary = "Récupère la liste des catégories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @GetMapping(value = "/all")
    public List<Categorie> getAllCategories() {
        return catService.getAllCat();
    }


    @Operation(summary = "Récupère une catégorie par sin ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @GetMapping(value = "/{id}")
    public Categorie getCategoryById(@PathVariable("id") Long id){ return catService.getCatById(id);}


    @Operation(summary = "Crée une catégorie dans la base de données")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @PostMapping(value = "/createCategorie")
    public Categorie createCategorie(@RequestBody Categorie categorie) {
        return catService.saveCategory(categorie);
    }

    @Operation(summary = "Met à jour une catégorie dans la base de données")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @PutMapping(value = "/updateCategory")
    public Categorie updateCategorie(@RequestBody Categorie cat) {
        return catService.updateCategory(cat);
    }

    @Operation(summary = "Supprime une catégorie de la base de données")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @DeleteMapping(value = "/deleteCategorie/{id}")
    public void deleteCategorie(@PathVariable("id") Long id){ catService.deleteCategoryById(id);}

}


