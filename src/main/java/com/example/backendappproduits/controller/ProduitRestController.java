package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Produit;
import com.example.backendappproduits.service.ProduitService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "*")
@Tag(name="ProductController")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

    @Operation(summary = "Récupère la liste des produits")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    }
    )
    @GetMapping(value = "/all")
    public List<Produit> getAllProduits() {

        return produitService.getAllProduits();

    }

    @Operation(summary = "Récupère un produit à partir de son ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @GetMapping(value = "/{id}")
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @Operation(summary = "Crée un nouveau produit et le sauvegarde dans la base de donnée")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @PostMapping(value = "/createProduct")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }


    @Operation(summary = "Met à jour un produit dans la base de donnée")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @PutMapping(value = "/updateProduct")
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }


    @Operation(summary= "Supprime un produit de la base de donnée")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduitById(id);
    }


    @Operation(summary = "Récupère une liste de produits par l'ID d une catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @GetMapping(value = "/prodscat/{idCat}")
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

    @Operation(summary = "Trouve un ou plusieurs produits par leur nom ou catégorie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "404", description = "Response not found")
    })
    @GetMapping(value = "/searchProd/{nameProd}")
    public List<Produit> getProduitByNameOrCategory(@PathVariable("nameProd") String nameProd) {
        return produitService.searchProductByNameProdOrCat(nameProd);
    }

}
