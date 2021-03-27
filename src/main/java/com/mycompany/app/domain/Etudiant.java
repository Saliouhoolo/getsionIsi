package com.mycompany.app.domain;

public class Etudiant {
    private int idE;
    private String nom;
    private  String prenom;
    private String tel;


    public Etudiant(int idE, String nom, String prenom, String tel) {
        this.idE = idE;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;

    }

    public Etudiant() {

    }

    public int getIdE() {
        return idE;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
