package com.eql.service;

import com.eql.model.Commande;
import com.eql.model.Produit;
import com.eql.model.User;

import java.util.List;
import java.util.Map;

public interface CommandeService {


    void ajoueCommande(User user, Double total, Map<Produit,Integer> panier);

    List<Commande> getAll();
    List<Commande> getcommandeByUser(User user);




}
