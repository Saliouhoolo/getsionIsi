package com.mycompany.app.service.console;

import com.mycompany.app.domain.Etudiant;
import com.mycompany.app.repository.jdbc.EtudiantRepository;
import com.mycompany.app.service.DisplayeEtudiant;
import com.mycompany.app.service.MenuEtudiant;

import java.util.Scanner;

public class ScannerMenuEtudiant  implements MenuEtudiant {
    private final Scanner scanner;
    private EtudiantRepository etudiantRepository;
    private DisplayeEtudiant displayeEtudiant;

    public ScannerMenuEtudiant(EtudiantRepository etudiantRepository, DisplayeEtudiant displayeEtudiant) {
        this.etudiantRepository = etudiantRepository;
        this.displayeEtudiant = displayeEtudiant;
        this.scanner = new Scanner(System.in);
    }
    private int lireChoix() {
        return scanner.nextInt();
    }
    private void afficherMenu( int choix) {

        Etudiant[] etudiants = etudiantRepository.getAll();
        switch (choix){
            case 1:
                displayeEtudiant.afficherListeEtudiants(etudiants);
                break;
            case 2:
                etudiantRepository.add(displayeEtudiant.addEtudiant()) ;
                displayeEtudiant.afficherListeEtudiants(etudiants);
                break;
            case 3:
                etudiantRepository.update(displayeEtudiant.updateEtudiant()) ;
                displayeEtudiant.afficherListeEtudiants(etudiants);
                break;
            case 4:
                etudiantRepository.delete(displayeEtudiant.deleteEtudiant()) ;
                displayeEtudiant.afficherListeEtudiants(etudiants);
                break;

            default:
                displayeEtudiant.afficherOptionInconnue();
        }

    }

    @Override
    public void afficherMenu() {
        int choix = lireChoix();
        afficherMenu(choix );
    }
}
