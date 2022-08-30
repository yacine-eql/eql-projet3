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
    public void ajoutroduit(Produit produit) {
        produitRepository.save(produit);
    }

    @Override
    public List<Produit> getAllProduct() {
        return produitRepository.findAll();
    }

    @Override
    public Produit getProduitById(int id) {
        return produitRepository.findById(id).get();
    }
}
