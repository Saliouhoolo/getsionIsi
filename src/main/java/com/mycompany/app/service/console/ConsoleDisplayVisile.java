package com.mycompany.app.service.console;


import com.mycompany.app.domain.Visile;
import com.mycompany.app.service.DisplayeVisile;

import java.util.Scanner;

public class ConsoleDisplayVisile implements DisplayeVisile {


    @Override
    public void afficherBienvenu() {
        System.out.println("Bienvenue sur La plateForme de l'institut Supérieur de l'informatique a dakar ");
    }

    @Override
    public void afficherMenuPrincipal() {
        System.out.println("1 lister des  visiles");
        System.out.println("2 ajouter un visiles");
        System.out.println("3 modifier un visiles ");
        System.out.println("4 supprimer un viiles");
    }

    @Override
    public void afficherListeVisiles(Visile[] visiles) {
        System.out.println("Les offres disponibles sont:");
        for (int i = 0; i < visiles.length; i++) {
            Visile visile =visiles[i];
            System.out.println(String.format("> %s %s %s %s %s", visile.getIdV(), visile.getNom(),visile.getPrenom(),visile.getMatricule()));
        }

    }
    @Override
    public Visile addVisile() {
        Visile visile=new Visile();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom");
        visile.setNom(sc.nextLine());
        System.out.println("entrer la prenom");
        visile.setPrenom(sc.nextLine());
        System.out.println("entrer le Matricule du vigile");
        visile.setMatricule(sc.nextLine());
        return visile;
    }

    @Override
    public void afficherOptionInconnue() {
        System.out.println("Menu vigile nom Trouvable");

    }

    @Override
    public Visile updateVisile() {
        Visile visile= new Visile();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer l'id du Professeur");
        // etudiant.set(sc.nextLine());
        System.out.println("entrer le nom");
        visile.setNom(sc.nextLine());
        System.out.println("entrer le prenom");
        visile.setPrenom(sc.nextLine());
        System.out.println("entrer le numero telephone du visile");
        visile.setMatricule(sc.nextLine());
        return  visile;
    }

    @Override
    public int deleteVisile() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id du visile");
        return  scanner.nextInt();
    }
}
