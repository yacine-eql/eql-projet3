package com.eql.service;

import com.eql.model.Commande;
import com.eql.model.Livreur;
import com.eql.model.Produit;
import com.eql.model.User;

import java.util.List;
import java.util.Map;


public interface LivreurService {


    void ajoueLivreur(Livreur livreur);

    void updateLivreur(Livreur livreur);

    List<Livreur> getAll();

    void deleteLivreur(Integer id);

    Livreur findLivreurByDI(int id);
    Livreur findLivreurByPrenom(String prenom);



}
