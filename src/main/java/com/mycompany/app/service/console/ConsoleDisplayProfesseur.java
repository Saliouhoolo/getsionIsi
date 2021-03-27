package com.mycompany.app.service.console;



import com.mycompany.app.domain.Professeur;
import com.mycompany.app.service.DisplayeProfesseur;

import java.util.Scanner;

public class ConsoleDisplayProfesseur implements DisplayeProfesseur {
    public void afficherBienvenu() {
        System.out.println("Bienvenue sur La plateForme de l'institut Supérieur de l'informatique a dakar ");
    }



    @Override
    public void afficherMenuPrincipal() {
        System.out.println("1 lister des  professeurs");
        System.out.println("2 ajouter un professeur");
        System.out.println("3 modifier un professeur ");
        System.out.println("4 supprimer un professeur");
    }

    @Override
    public void afficherListeProfessuers(Professeur[] professeurs) {
        System.out.println("Les offres disponibles sont:");
        for (int i = 0; i < professeurs.length; i++) {
            Professeur professeur =professeurs[i];
            System.out.println(String.format("> %s %s %s %s %s", professeur.getIdPro(), professeur.getNom(),professeur.getPrenom(),professeur.getTel(),professeur.getEmail()));
        }

    }

    @Override
    public Professeur addProfesseur() {
        Professeur professeur = new Professeur();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer le nom");
        professeur.setNom(sc.nextLine());
        System.out.println("entrer la prenom");
        professeur.setPrenom(sc.nextLine());
        System.out.println("entrer le tel");
        professeur.setTel(sc.nextLine());
        System.out.println("entrer l'email du Professeur");
        professeur.setEmail(sc.nextLine());
        return professeur;

    }
    @Override
    public void afficherOptionInconnue() {
        System.out.println("Menu professeur nom Trouvable");
    }


    @Override
    public Professeur updateProfesseur() {
        Professeur professeur= new Professeur();
        Scanner sc = new Scanner(System.in);
        System.out.println("entrer l'id du Professeur");
        // etudiant.set(sc.nextLine());
        System.out.println("entrer le nom");
        professeur.setNom(sc.nextLine());
        System.out.println("entrer la prenom");
        professeur.setPrenom(sc.nextLine());
        System.out.println("entrer le numero telephone du professeur");
        professeur.setTel(sc.nextLine());
        System.out.println("entrer l'email du Professeur");
        professeur.setEmail(sc.nextLine());



        return professeur;
    }

    @Override
    public int deleteProfesseur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("saisir l'id de l'etudiant à supprimer");
        return  scanner.nextInt();

    }

}
