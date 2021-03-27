package com.mycompany.app.service.console;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Etudiant;
import com.mycompany.app.service.DisplayeClasse;

import java.util.Scanner;

public class ConsoleDisplayClasse implements DisplayeClasse {


    @Override
    public void afficherBienvenu() {
        System.out.println("Bienvenue sur La plateForme de l'institut Supérieur de l'informatique a dakar ");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("1 lister des  Classe");
        System.out.println("2 ajouter une Classe");
        System.out.println("3 modifier une Classe");
        System.out.println("4 supprimer un Classe");

    }

    @Override
    public void afficherListeClasses(Classe[] classes) {
        System.out.println("Les offres disponibles sont:");
        for (int i = 0; i < classes.length; i++) {
            Classe classe = classes[i];
            System.out.println(String.format("> %s %s %s %s %s", classe.getIdC(), classe.getnomSalle(),classe.getnumero()));
        }

    }

    @Override
    public Classe addClasse() {
        Classe classe = new Classe();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom du salle");
        classe.setnomSalle(sc.nextLine());
        System.out.println("entrer le numero du classe");
        classe.setnumero(sc.nextLine());

        return classe;

    }

    @Override
    public void afficherOptionInconnue() {
        System.out.println("Menu Classe Introuvable");
    }

    @Override
    public Classe updateClasse() {
        Classe classe= new Classe();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer l'id de l'etudiant");
        // etudiant.set(sc.nextLine());
        System.out.println("entrer le nomdu Sale");
        classe.setnomSalle(sc.nextLine());
        System.out.println("entrer le numero du classe");
        classe.setnumero(sc.nextLine());

        return classe;
    }

    @Override
    public int deleteClasse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'etudiant à supprimer");
        return  scanner.nextInt();

    }
}

