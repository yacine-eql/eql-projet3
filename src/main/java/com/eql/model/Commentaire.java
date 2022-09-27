package com.eql.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue
    private int idCommentaire ;
    private String evaluation;
    private Date dateEval;
    private Date dateCom;

    @ManyToOne
    private Produit produit;

    public Commentaire(String evaluation) {
        this.evaluation = evaluation;
    }

    public Commentaire() {
    }

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Date getDateEval() {
        return dateEval;
    }

    public void setDateEval(Date dateEval) {
        this.dateEval = dateEval;
    }

    public Date getDateCom() {
        return dateCom;
    }

    public void setDateCom(Date dateCom) {
        this.dateCom = dateCom;
    }
}
