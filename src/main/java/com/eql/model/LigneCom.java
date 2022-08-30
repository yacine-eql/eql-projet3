package com.eql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LigneCom {

    @Id
    @GeneratedValue
    private int ligneComId;
    private int quantite;

    private double prixAchat;

    @ManyToOne
    private Commande commande;

    @ManyToOne
    private Produit produit;


    public LigneCom() {
    }

    public LigneCom(int quantite,  double prixAchat) {
        this.quantite = quantite;

        this.prixAchat = prixAchat;
    }

    public int getLigneComId() {
        return ligneComId;
    }

    public void setLigneComId(int ligneComId) {
        this.ligneComId = ligneComId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(double prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return     produit + " " + quantite + " ";
    }
}
