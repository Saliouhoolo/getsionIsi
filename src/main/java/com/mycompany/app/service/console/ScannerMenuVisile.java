package com.mycompany.app.service.console;

import com.mycompany.app.domain.Visile;
import com.mycompany.app.repository.jdbc.VisileRepository;
import com.mycompany.app.service.MenuVisile;
import com.mycompany.app.service.DisplayeVisile;

import java.util.Scanner;
public class ScannerMenuVisile {
    private Scanner scanner;
    private VisileRepository visileRepository;
    private DisplayeVisile displayeVisile;
    public ScannerMenuVisile(VisileRepository visileRepository, DisplayeVisile displayeVisile) {
        this.visileRepository = visileRepository;
        this.displayeVisile = displayeVisile;
        this.scanner = new Scanner(System.in);
    }
    private int lireChoix() {
        return scanner.nextInt();
    }
    private void afficherMenu( int choix) {

        Visile [] visiles= visileRepository.getAll();
        switch (choix){
            case 1:
                displayeVisile.afficherListeVisiles(visiles);
                break;
            case 2:
                visileRepository.add(displayeVisile.addVisile());
                displayeVisile.addVisile();
                break;
            case 3:
                visileRepository.update(displayeVisile.updateVisile());
                break;
            case 4:
                visileRepository.delete(displayeVisile.deleteVisile());
                displayeVisile.deleteVisile();
                break;

            default:
                displayeVisile.afficherOptionInconnue();
        }

    }
    public void afficherMenu() {
        int choix = lireChoix();
        afficherMenu(choix );
    }

}
