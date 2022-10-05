package com.eql.service.impl;

import com.eql.model.Categorie;
import com.eql.repository.CategorieRepository;
import com.eql.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    CategorieRepository categorieRepository;


    @Override
    public List<Categorie> findAllCategories() {
        return categorieRepository.findAll();
    }
}
