package com.eql.service.impl;

import com.eql.repository.ProduitRepository;
import com.eql.model.Produit;
import com.eql.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Override
    public Produit getProduitByLabel(String label) {
        return produitRepository.getProduitByLabel(label);
    }

    @Override
    public void ajoutroduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduct() {
        return produitRepository.findAll();
    }

    @Override
    public List<Produit> getBasiques() {
        return produitRepository.getBasiques();
    }

    @Override
    public List<Produit> getIncontournables() {
        return produitRepository.getIncontournables();
    }

    @Override
    public List<Produit> getSupremes() {
        return produitRepository.getSupremes();
    }

    @Override
    public List<Produit> getBoissons() {
        return produitRepository.getBoissons();
    }

    @Override
    public List<Produit> getDesserts() {
        return produitRepository.getDesserts();
    }

    @Override
    public Produit getProduitById(int id) {
        return produitRepository.findById(id).get();
    }


}
