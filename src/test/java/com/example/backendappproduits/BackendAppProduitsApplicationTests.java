package com.example.backendappproduits;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.models.Produit;
import com.example.backendappproduits.repository.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class BackendAppProduitsApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;

    @Test
    public void testCreateProduit() {
        Produit prod = new Produit("PC Asus",1400.500,new Date());
        produitRepository.save(prod);
    }

    /*
    @Test
    public void testFindProduit() {
        Produit p = produitRepository.findById(1L).get();
        System.out.println(p);
    }

    @Test
    public void testUpdateProduit() {
        Produit p = produitRepository.findById(1L).get();
        p.setPrixProduit(1000.0);
        produitRepository.save(p);
    }*/

    @Test
    public void testDeleteProduit() {
        produitRepository.deleteById(1L);
    }

    @Test
    public void testListerAllProduits() {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

    @Test
    public void testFindProduitsByName() {

        List<Produit> prods = produitRepository.findByNomProduit("PC Mac");

        for (Produit p : prods)

        {
            System.out.println(p);
        }
    }

    @Test
    public void testFindProduitsByNameContains() {

        List<Produit> prods = produitRepository.findByNomProduitContains("a");

        for (Produit p : prods)

        {
            System.out.println(p);
        }
    }

    @Test
    public void testfindByNomPrix() {
        List<Produit> prods = produitRepository.findByNomPrix("PC Asus", 1000.0);

        for (Produit p : prods)
        {

            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorie() {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);

        List<Produit> prods = produitRepository.findByCategorie(cat);

        for(Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByCategorieIdCat() {
        Categorie cat = new Categorie();
        cat.setIdCat(1L);

        List<Produit> prods = produitRepository.findByCategorieIdCat(1L);

        for(Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testFindByOrderByNomProduitAsc() {

        List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();

        for(Produit p : prods) {
            System.out.println(p);
        }
    }

    @Test
    public void testTrierProduitsNomsPrix() {

        List<Produit> prods = produitRepository.trierProduitsNomsPrix();

        for(Produit p : prods) {
            System.out.println(p);
        }
    }

}
