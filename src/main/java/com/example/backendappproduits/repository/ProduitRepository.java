package com.example.backendappproduits.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.backendappproduits.models.Categorie;
import com.example.backendappproduits.models.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);

	/*
	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2") paramètres par position
	List<Produit> findByNomPrix (String nom, Double prix);
	*/

    @Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix") //paramètres nommés
    List<Produit> findByNomPrix (@Param("nom") String nom, @Param("prix") Double prix);

    @Query("select p from Produit p where p.categorie = :cat")
    List<Produit> findByCategorie (@Param("cat") Categorie categorie);

    List<Produit> findByCategorieIdCat(Long id);

    List<Produit> findByOrderByNomProduitAsc();

    @Query("select p from Produit p order by p.nomProduit ASC , p.prixProduit ASC")
    List<Produit> trierProduitsNomsPrix();

}
