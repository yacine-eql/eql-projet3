package com.eql.service.impl;

import com.eql.model.*;
import com.eql.repository.CommandeRepository;
import com.eql.repository.FactureRepository;
import com.eql.repository.LigneComRepository;
import com.eql.repository.UserRepository;
import com.eql.service.CommandeService;
import com.eql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    CommandeRepository commandeRepository;
    @Autowired
    LigneComRepository ligneComRepository;
    @Autowired
    FactureRepository factureRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void ajoueCommande(User user, Double total, Map<Produit,Integer> panier) {

        Commande commande = new Commande();
        Facture facture = new Facture();



        facture.setMontant(total);
        facture.setDateFacturation(new Date());
        factureRepository.save(facture);
        commande.setUser(user);
        commande.setCommandeDate(new Date());
        commande.setFacture(facture);
        commandeRepository.save(commande);


        List<LigneCom> ligneComList = new ArrayList<>();

        for (Map.Entry<Produit, Integer> entry : panier.entrySet()) {
            LigneCom ligneCom =new LigneCom();
           ligneCom.setProduit(entry.getKey());
           ligneCom.setQuantite(entry.getValue());
           ligneCom.setPrixAchat(entry.getKey().getPrix());
           ligneCom.setCommande(commande);
           ligneComList.add(ligneCom);
            commande.setLigneComs(ligneComList);
            ligneComRepository.save(ligneCom);

        }



        }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public List<Commande> getcommandeByUser(User user) {

        return user.getCommandes();
    }

    @Override
    public Commande getComById(Integer id) {
        return commandeRepository.findById(id).get();
    }

    @Override
    public void saveCom(Commande com) {
        commandeRepository.save(com);
    }


}
