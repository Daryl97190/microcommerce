package com.ecommerce.microcommerce.dao;

import java.util.List;

import com.ecommerce.microcommerce.model.Produit;

public interface ProduitDao {


    public List<Produit> findAll();

    public Produit findById(int id);

    public Produit save(Produit product);

    
}
