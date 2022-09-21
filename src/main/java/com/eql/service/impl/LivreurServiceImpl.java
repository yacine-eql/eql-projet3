package com.eql.service.impl;

import com.eql.model.Livreur;
import com.eql.repository.LivreurRepository;
import com.eql.service.LivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivreurServiceImpl implements LivreurService {

    @Autowired
    LivreurRepository livreurRepository;

    @Override
    public void ajoueLivreur(Livreur livreur) {
        Livreur newLivreur = new Livreur();
        newLivreur.setNom(livreur.getNom());
        newLivreur.setPrenom(livreur.getPrenom());
        newLivreur.setTel(livreur.getTel());
        newLivreur.setAdresse(livreur.getAdresse());
        livreurRepository.save(newLivreur);
    }

    @Override
    public void updateLivreur(Livreur livreur) {

        livreurRepository.save(livreur);
    }

    @Override
    public List<Livreur> getAll() {
        return livreurRepository.findAll();
    }

    @Override
    public void deleteLivreur(Integer id) {
        livreurRepository.deleteById(id);
    }

    @Override
    public Livreur findLivreurByDI(int id) {
        return livreurRepository.findById(id).get();
    }
}
