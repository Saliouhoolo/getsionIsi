package com.mycompany.app.service.console;

import com.mycompany.app.domain.Classe;
import com.mycompany.app.repository.jdbc.ClasseRepository;
import com.mycompany.app.service.DisplayeClasse;

import java.util.Scanner;

public class ScannerMenuClasse {
    private final Scanner scanner;
    private ClasseRepository classeRepository;
    private DisplayeClasse displayeClasse;

    public ScannerMenuClasse(ClasseRepository classeRepository, DisplayeClasse displayeClasse) {
        this.classeRepository = classeRepository;
        this.displayeClasse= displayeClasse;
        this.scanner = new Scanner(System.in);
}
    private int lireChoix() {
        return scanner.nextInt();
    }
    private void afficherMenu( int choix) {

        Classe[] classe = classeRepository.getAll();
        switch (choix){
            case 1:
                displayeClasse.afficherListeClasses(classe);
                break;
            case 2:
                classeRepository.add(displayeClasse.addClasse()) ;
                displayeClasse.afficherListeClasses(classe);
                break;
            case 3:
                classeRepository.update(displayeClasse.updateClasse()) ;
                displayeClasse.afficherListeClasses(classe);
                break;
            case 4:
                classeRepository.delete(displayeClasse.deleteClasse()) ;
                displayeClasse.afficherListeClasses(classe);
                break;

            default:
                displayeClasse.afficherOptionInconnue();
        }

    }

}
