package com.ecommerce.microcommerce.controller;

import java.util.List;

import com.ecommerce.microcommerce.dao.ProduitDao;
import com.ecommerce.microcommerce.model.Produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduitController {

    @Autowired
    private ProduitDao produitDao;

    @GetMapping(value = "/produits")
    public List<Produit> listeProduits() {
        return produitDao.findAll();
    }
    
    @GetMapping(value = "/produits/{id}")
    public Produit afficherUnProduit(@PathVariable int id) {
        Produit produit = new Produit(id, new String("Aspirateur"), 100);
        return produit;
    }
    
    // ajouter un produit
    @PostMapping(value = "/produits")
    public void ajouterProduit(@RequestBody Produit produit) {
        produitDao.save(produit);
    }
    
}
