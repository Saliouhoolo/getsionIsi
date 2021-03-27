package com.mycompany.app.domain;

public class Classe {
    private int idC;
    private String nomSalle;
    private String numero;


    public Classe(int idC, String nomSalle, String numero) {
        this.idC= idC;
        this.nomSalle = nomSalle;
        this.numero = numero;
    }

    public Classe() {

    }

    public static void add(Classe classe) {
    }

    public int getIdC() {
        return idC;
    }


    public String getnomSalle() {
        return nomSalle;
    }

    public void setnomSalle(String nomSalle) {
        this.nomSalle= nomSalle;
    }
    public String getnumero() {
        return  numero;
    }

    public void setnumero(String  numero) {
        this. numero=  numero;
    }


    @Override
    public String toString() {
        return "Classe{" +
                "idC=" + idC +
                '}';
    }
}
