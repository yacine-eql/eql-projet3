package com.eql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Facture {

    @Id
    @GeneratedValue
    private int factureId;


    private Date dateFacturation;

    private double montant;

    @OneToOne(mappedBy = "facture")
     Commande commandeF  ;

    public Facture(Date dateFacturation, Commande commande) {
        this.dateFacturation = dateFacturation;
        this.commandeF = commande;
        this.montant = commandeF.calculMontant();
        commande.setFacture(this);
    }

    public Facture() {
    }

    public int getFactureId() {
        return factureId;
    }

    public void setFactureId(int factureId) {
        this.factureId = factureId;
    }

    public Date getDateFacturation() {
        return dateFacturation;
    }

    public void setDateFacturation(Date dateFacturation) {
        this.dateFacturation = dateFacturation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Commande getCommandeF() {
        return commandeF;
    }

    public void setCommandeF(Commande commandeF) {
        this.commandeF = commandeF;
    }
}
