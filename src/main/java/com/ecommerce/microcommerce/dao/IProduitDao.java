package com.ecommerce.microcommerce.dao;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.microcommerce.model.Produit;

import org.springframework.stereotype.Repository;

@Repository
public class IProduitDao implements ProduitDao {
    
    public static List<Produit> produits = new ArrayList<>();
    static {
        produits.add(new Produit(1, new String("Ordinateur portable"), 350 , 333));
        produits.add(new Produit(2, new String("Aspirateur Robot"), 500, 250));
        produits.add(new Produit(3, new String("Table de Ping Pong"), 750, 620));
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for (Produit produit : produits) {
            if (produit.getId() == id) {
                return produit;
            }
        }
        return null;
    }

    @Override
    public Produit save(Produit produit) {
        produits.add(produit);
        return produit;
    }
    
}
