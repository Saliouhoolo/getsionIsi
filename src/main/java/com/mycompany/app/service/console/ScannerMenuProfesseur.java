package com.mycompany.app.service.console;


import com.mycompany.app.domain.Professeur;
import com.mycompany.app.repository.jdbc.ProfesseurRepository;
import com.mycompany.app.service.DisplayeProfesseur;

import java.util.Scanner;

public class ScannerMenuProfesseur {
    private Scanner scanner;
    private ProfesseurRepository professeurRepository;
    private DisplayeProfesseur displayeProfesseur;
    public ScannerMenuProfesseur(ProfesseurRepository professeurRepository, DisplayeProfesseur displayeProfesseur) {
        this.professeurRepository = professeurRepository;
        this.displayeProfesseur = displayeProfesseur;
        this.scanner = new Scanner(System.in);
    }
    private int lireChoix() {
        return scanner.nextInt();
    }
    private void afficherMenu( int choix) {

        Professeur[] professeurs = professeurRepository.getAll();
        switch (choix){
            case 1:
                displayeProfesseur.afficherListeProfessuers(professeurs);
                break;
            case 2:
                professeurRepository.add(displayeProfesseur.addProfesseur());
                displayeProfesseur.addProfesseur();
                break;
            case 3:
                professeurRepository.update(displayeProfesseur.updateProfesseur());
                break;
            case 4:
                professeurRepository.delete(displayeProfesseur.deleteProfesseur());
                displayeProfesseur.deleteProfesseur();
                break;

            default:
                displayeProfesseur.afficherOptionInconnue();
        }

    }
    public void afficherMenu() {
        int choix = lireChoix();
        afficherMenu(choix );
    }
}
