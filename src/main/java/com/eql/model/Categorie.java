package com.eql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue
    private int id;

    private String  label;

    @OneToMany(mappedBy = "categorie",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Produit> produits = new ArrayList<>();


    public  void addProduits(Produit c){
        produits.add(c);
        c.setCategorie(this);

    }

    public Categorie(String label) {
        this.label = label;
    }

    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
