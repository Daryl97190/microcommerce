package com.ecommerce.microcommerce.model;

public class Produit {


    private int id;
    private String nom;
    private int prix;

    


    public Produit() {
    }
    public Produit(int id, String nom, int prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }
    //GETTER & SETTER
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    
    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
    }
    
    

    
    
}
