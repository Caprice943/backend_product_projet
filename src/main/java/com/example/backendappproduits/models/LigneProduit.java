package com.example.backendappproduits.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name="tb_ligne_prod")
@Getter
 @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LigneProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String groupLabel;

    @NotNull
    private String appCode;
}
