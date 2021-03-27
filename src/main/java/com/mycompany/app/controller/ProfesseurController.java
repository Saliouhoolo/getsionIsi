package com.mycompany.app.controller;

import com.mycompany.app.repository.jdbc.DataSource;
import com.mycompany.app.repository.jdbc.MysqlDataSource;
import com.mycompany.app.repository.jdbc.ProfesseurRepository;
import com.mycompany.app.repository.jdbc.jdbcProfesseurRepository;
import com.mycompany.app.service.DisplayeProfesseur;
import com.mycompany.app.service.console.ConsoleDisplayProfesseur;
import com.mycompany.app.service.console.ScannerMenuProfesseur;

public class ProfesseurController {
    private final DisplayeProfesseur displayeProfesseur;
    private final ScannerMenuProfesseur scannerMenuProfesseur;

    public ProfesseurController(){
        displayeProfesseur = new ConsoleDisplayProfesseur();
        DataSource dataSource = new MysqlDataSource();
        ProfesseurRepository professeurRepository = new jdbcProfesseurRepository(dataSource) {
            @Override
            public int deleteProfesseur() {
                return 0;
            }
        };
        scannerMenuProfesseur = new ScannerMenuProfesseur(professeurRepository,displayeProfesseur);
    }
    public  void process(){
        displayeProfesseur.afficherBienvenu();
        displayeProfesseur.afficherBienvenu();
        scannerMenuProfesseur.afficherMenu();
    }
}
