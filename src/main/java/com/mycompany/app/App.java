package com.mycompany.app;


import com.mycompany.app.service.console.ScannerMenuClasse;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Bienvenue sur la plateforme de l'institut Superieur de l'informatique de Dakar");
        System.out.println("> E pour lister l'ensemble des etudiants");
        Scanner scanner = new Scanner(System.in);
        String Etudiant = scanner.next();
        if ("E".equalsIgnoreCase(Etudiant)) {
            System.out.println(" lister l'ensemble des etudiants:");
            System.out.println(">>P -Professeur");
            System.out.println(">>C -Classe");
            System.out.println(">>V -Visile");
            String Classe = scanner.next();
            if ("P".equalsIgnoreCase(Classe)) {
                System.out.println(">>>> liste des professeurs:");
                System.out.println(">>>> 1 Matar Thioye");
                System.out.println(">>>> 2 Kader Fall Java");
                System.out.println(">>>> 3 Nawal Touré");
                System.out.println(">>>> 4 Lamine Dieng Cloud");
                String choix = scanner.next();
                if ("1".equalsIgnoreCase(choix)) {

                    System.out.println(">>>> 1 Professeur Habite a ouakam");
                    System.out.println(">>>> 2 Professeur Habite a liberté6");
                    System.out.println(">>>> 3 Professeur Habite a saint djourbel");
                    System.out.println(">>>> 4 Professeur Habite a Dakar");
                    String Professeur = scanner.next();
                    if ("E".equalsIgnoreCase(Etudiant)) {
                        System.out.println(">>>> Cours a L'institut Supérieur de L'informatique");
                        System.out.println(">>>> L'heure est ? hh:mm");
                        String heureMinute = scanner.next();
                        System.out.println(String.format(">>>> ok pour %s", heureMinute));
                    }
                } else if ("C".equalsIgnoreCase(Classe)) {
                    System.out.println(" liste des professeurs:");
                } else if ("V".equalsIgnoreCase(Classe)) {
                    System.out.println(" liste des professeurs:");
                } else {
                    System.out.println("Option inconnue");
                }
            } else {
                System.out.println("Etudiants inconnu de l'etablissement");
            }

        }
    }
}
