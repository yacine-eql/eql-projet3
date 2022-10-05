package com.eql.repository;

import com.eql.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitRepository extends JpaRepository<Produit,Integer> {

Produit getProduitByLabel(String label);

    @Query(value = "SELECT * FROM `produit` WHERE `categorie_id`=1 AND `is_active` =false", nativeQuery = true)
    List<Produit> getBasiques();

    @Query(value = "SELECT * FROM `produit` WHERE `categorie_id`=2 AND `is_active` =false", nativeQuery = true)
    List<Produit> getIncontournables();

    @Query(value = "SELECT * FROM `produit` WHERE `categorie_id`=3 AND `is_active` =false", nativeQuery = true)
    List<Produit> getSupremes();

    @Query(value = "SELECT * FROM `produit` WHERE `categorie_id`=5 AND `is_active` =false", nativeQuery = true)
    List<Produit> getDesserts();

    @Query(value = "SELECT * FROM `produit` WHERE `categorie_id`=4 AND `is_active` =false", nativeQuery = true)
    List<Produit> getBoissons();

}
