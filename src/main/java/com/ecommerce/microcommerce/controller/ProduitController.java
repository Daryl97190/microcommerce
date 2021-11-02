package com.ecommerce.microcommerce.controller;

import java.net.URI;
import java.util.List;

import com.ecommerce.microcommerce.dao.ProduitDao;
import com.ecommerce.microcommerce.model.Produit;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ProduitController {

    @Autowired
    private ProduitDao produitDao;

    @GetMapping(value = "/produits")
    public MappingJacksonValue listeProduits() {

        List<Produit> produits = produitDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);

        produitsFiltres.setFilters(listDeNosFiltres);

        return produitsFiltres;
    }

    // public List<Produit> listeProduits() {
    //     return produitDao.findAll();
    // }
    
    @GetMapping(value = "/produits/{id}")
    public Produit afficherUnProduit(@PathVariable int id) {
        
        return produitDao.findById(id);
    }
    
    // ajouter un produit
    @PostMapping(value = "/produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Produit produit) {

        Produit productAjouter = produitDao.save(produit);

        if (productAjouter == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(productAjouter.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
    
}
