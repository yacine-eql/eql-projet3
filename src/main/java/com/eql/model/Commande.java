package com.eql.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity

public class Commande {

    @Id
    @GeneratedValue
    private int commandeId;

    private Date commandeDate;

    @ManyToOne
    private Livreur livreur;
    @ManyToOne
    private User user;

    @OneToOne
    @JoinColumn(name = "facture_id", referencedColumnName = "factureId")
    private Facture facture;

    @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
    private List<LigneCom> ligneComs = new ArrayList<>();


    public double calculMontant(){
        double result = 0;
        for (LigneCom ligneCom : ligneComs) {
            result = result + (ligneCom.getQuantite()*ligneCom.getPrixAchat());
        }
        return result;
    }


    public Commande(Date commandeDate) {
        this.commandeDate = commandeDate;
    }

    public Commande() {
    }

    public  void addLigneCom(LigneCom c){
        ligneComs.add(c);
        c.setCommande(this);

    }



    public int getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(int commandeId) {
        this.commandeId = commandeId;
    }

    public Date getCommandeDate() {
        return commandeDate;
    }

    public void setCommandeDate(Date commandeDate) {
        this.commandeDate = commandeDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public List<LigneCom> getLigneComs() {
        return ligneComs;
    }

    public void setLigneComs(List<LigneCom> ligneComs) {
        this.ligneComs = ligneComs;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "commandeId=" + commandeId +
                ", commandeDate=" + commandeDate +
                ", facture=" + facture +
                '}';
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }
}
