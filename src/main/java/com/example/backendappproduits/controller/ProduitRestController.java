package com.example.backendappproduits.controller;

import com.example.backendappproduits.models.Produit;
import com.example.backendappproduits.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin(origins = "http://localhost:4200")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;

    //@RequestMapping(method= RequestMethod.GET)
    @GetMapping(value = "/all")
    public List<Produit> getAllProduits() {

        return produitService.getAllProduits();

    }

    @GetMapping(value="/{id}")
    public Produit getProduitById(@PathVariable("id") Long id)
    {
        return produitService.getProduit(id);
    }

    @PostMapping(value = "/createProduct")
    public Produit createProduit(@RequestBody Produit produit)
    {
        return produitService.saveProduit(produit);
    }

    @PutMapping(value = "/updateProduct")
    public Produit updateProduit(@RequestBody Produit produit)
    {
        return produitService.updateProduit(produit);
    }

    @DeleteMapping(value = "/deleteProduct/{id}")
    public void deleteProduit(@PathVariable("id") Long id)
    {
        produitService.deleteProduitById(id);
    }

    @GetMapping(value = "/prodscat/{idCat}")
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat)
    {
        return produitService.findByCategorieIdCat(idCat);
    }

}
