package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Produit;
import com.example.backendappproduits.service.ProduitService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "*")
//@Api(value = "API pour les produits")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

   // @ApiOperation(value = "Récupère la liste des produits")
    @GetMapping(value = "/all")
    public List<Produit> getAllProduits() {

        return produitService.getAllProduits();

    }

    //@ApiOperation(value = "Récupère un produit à partir de son ID")
    @GetMapping(value = "/{id}")
    public Produit getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    //@ApiOperation(value = "Crée un nouveau produit et le sauvegarde dans la base de donnée")
    @PostMapping(value = "/createProduct")
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }


    //@ApiOperation(value = "Met à jour un produit dans la base de donnée")
    @PutMapping(value = "/updateProduct")
    public Produit updateProduit(@RequestBody Produit produit) {
        return produitService.updateProduit(produit);
    }


    //@ApiOperation(value = "Supprime un produit de la base de donnée")
    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduitById(id);
    }


    //@ApiOperation(value = "Récupère une liste de produits par l'ID d une catégorie")
    @GetMapping(value = "/prodscat/{idCat}")
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

    //@ApiOperation(value = "Trouve un ou plusieurs produits par leur nom ou catégorie")
    @GetMapping(value = "/searchProd/{nameProd}")
    public List<Produit> getProduitByNameOrCategory(@PathVariable("nameProd") String nameProd) {
        return produitService.searchProductByNameProdOrCat(nameProd);
    }

}
