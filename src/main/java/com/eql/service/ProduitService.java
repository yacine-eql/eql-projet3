package com.eql.service;

import com.eql.model.Produit;

import java.util.List;


public interface ProduitService {

    Produit getProduitByLabel(String label);
    void ajoutroduit(Produit produit);

    List<Produit> getAllProduct();
    List<Produit> getBasiques();
    List<Produit> getIncontournables();
    List<Produit> getSupremes();
    List<Produit> getBoissons();
    List<Produit> getDesserts();

    void deleteProduct(Integer id);

    void updateProduct(Produit produit);

    Produit getProduitById(int id);


}
