package com.example.backendappproduits.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
    private String nomCat;
    private String descriptionCat;

    @OneToMany(mappedBy = "categorie")
    @JsonIgnore
    private List<Produit> produits;
}
