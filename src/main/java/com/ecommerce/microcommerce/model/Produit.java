package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonFilter;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// @JsonIgnoreProperties(value = { "prixAchat", "id" })
@JsonFilter("monFiltreDynamique")
public class Produit {


    private int id;
    private String nom;
    private int prix;
    private int prixAchat;


    
    public Produit(int id, String nom, int prix, int prixAchat) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.prixAchat = prixAchat;
    }
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
    public int getPrixAchat() {
        return prixAchat;
    }
    public void setPrixAchat(int prixAchat) {
        this.prixAchat = prixAchat;
    }
    @Override
    public String toString() {
        return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + ", prixAchat=" + prixAchat + "]";
    }

}
