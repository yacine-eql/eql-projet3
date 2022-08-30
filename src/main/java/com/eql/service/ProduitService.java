package com.eql.service;

import com.eql.model.Produit;

import java.util.List;


public interface ProduitService {


    void ajoutroduit(Produit produit);

    List<Produit> getAllProduct();
    Produit getProduitById(int id);
}
