package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.model.Produit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {


    @GetMapping(value = "/produits")
    public String listeProduits() {
        return "Un exemple de produit";
    }
    
    @GetMapping(value = "/produits/{id}")
    public Produit afficherUnProduit(@PathVariable int id) {
        Produit produit = new Produit(id, new String("Aspirateur"), 100);
        return produit;
    }
    
}
