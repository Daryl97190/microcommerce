package com.ecommerce.microcommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {


    @GetMapping(value = "/produits")
    public String listeProduits() {
        return "Un exemple de produit";
    }
    
}
