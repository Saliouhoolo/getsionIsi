package com.mycompany.app.domain;

public class Professeur {
    private int idPro;
    private String nom;
    private String prenom;
    private String tel;
    private String email;



    public Professeur(int idPro, String nom, String prenom,String tel,String email) {
        this.idPro= idPro;
        this.nom = nom;
        this.prenom =  prenom;
        this.tel=  tel;
        this.email= email;
    }

    public Professeur() {

    }


    public static void add(Professeur professeur) {
    }

    public int getIdPro() {
        return idPro;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom =nom;
    }
    public String getPrenom() {
        return  prenom;
    }

    public void setPrenom(String  prenom) {
        this.prenom= prenom;
    }

    public String getTel() {
        return  tel;
    }

    public void setTel(String  tel) {
        this.tel= tel;
    }

    public String getEmail() {
        return  email;
    }

    public void setEmail(String  email) {
        this.email= email;
    }


    @Override
    public String toString() {
        return "Professeur{" +
                "idPro=" + idPro +
                '}';
    }
}
