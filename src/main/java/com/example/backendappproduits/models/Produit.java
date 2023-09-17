package com.example.backendappproduits.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;
    private String nomProduit;
    private Double prixProduit;
    private Date dateCreation;

    @ManyToOne
    private Categorie categorie;



    public Produit() {
        super();
    }


    public Produit(String nomProduit, Double prixProduit, Date dateCreation) {
        super();
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
    }


    public Long getIdProduit() {
        return idProduit;
    }
    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }
    public String getNomProduit() {
        return nomProduit;
    }
    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }
    public Double getPrixProduit() {
        return prixProduit;
    }
    public void setPrixProduit(Double prixProduit) {
        this.prixProduit = prixProduit;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Categorie getCategorie() {
        return categorie;
    }
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }


    @Override
    public String toString() {
        return "Produits [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit
                + ", dateCreation=" + dateCreation + "]";
    }

}
