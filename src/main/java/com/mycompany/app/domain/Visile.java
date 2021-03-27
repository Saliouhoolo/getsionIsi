package com.mycompany.app.domain;

public class Visile {
    private int idV;
    private String nom;
    private String prenom;
    private String Matricule;

    public Visile(){
        this.idV= idV;
        this.nom = nom;
        this.prenom = prenom;
        this.Matricule=Matricule;
    }
    public int getIdV() {
        return idV;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return Matricule;
    }

    public void setMatricule(String Matricule) {
        this.Matricule = Matricule;
    }
}
