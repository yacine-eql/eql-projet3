package com.eql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Produit {

    @Id
    @GeneratedValue
    private Integer produitId;
    private String label;
    private String description;
    private double prix;
    private String image;

    public List<LigneCom> getLigneComs() {
        return ligneComs;
    }

    public void setLigneComs(List<LigneCom> ligneComs) {
        this.ligneComs = ligneComs;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    @OneToMany(mappedBy = "produit",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   List<LigneCom> ligneComs = new ArrayList<>();

    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    List<Commentaire> commentaires = new ArrayList<>();



    @ManyToOne
    private Categorie categorie;

    public Produit(String label, String description, double prix) {
        this.label = label;
        this.description = description;
        this.prix = prix;
    }

    public Produit() {
    }

    public  void addLigneComP(LigneCom c){
        ligneComs.add(c);
        c.setProduit(this);

    }
    public  void addCommentaire(Commentaire c){
        commentaires.add(c);
        c.setProduit(this);

    }

    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produit produit = (Produit) o;
        return Objects.equals(produitId, produit.produitId) && Objects.equals(label, produit.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produitId, label);
    }

    @Override
    public String toString() {
        return  label ;
    }
}
