package com.example.backendappproduits.controller;


import com.example.backendappproduits.models.LigneProduit;
import com.example.backendappproduits.service.LigneProdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/lignProd")
@CrossOrigin(origins = "*")
@Tag(name = "LigneProduitController")
public class LigneProduitController {

    @Autowired
    private LigneProdService lpService;


    @Operation(summary = "Télécharge un fichier CSV qui remplit la table produit")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success response"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadCsv(@RequestPart("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Le fichier est vide.");
        } else {
            try {
                List<LigneProduit> csvList = lpService.readCsvFile(file);
                lpService.saveCsvList(csvList);
                return ResponseEntity.ok("Le fichier CSV a été traité avec succès.");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors du traitement du fichier CSV.");
            }
        }
    }
}