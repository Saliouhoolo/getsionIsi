package com.mycompany.app.controller;

import com.mycompany.app.repository.jdbc.DataSource;
import com.mycompany.app.repository.jdbc.EtudiantRepository;
import com.mycompany.app.repository.jdbc.JdbcEtudiantRepository;
import com.mycompany.app.repository.jdbc.MysqlDataSource;
import com.mycompany.app.service.DisplayeEtudiant;
import com.mycompany.app.service.console.ConsoleDisplayEtudiant;
import com.mycompany.app.service.console.ScannerMenuEtudiant;

public class EtudiantController {

    private final DisplayeEtudiant displayeEtudiant;
    private final ScannerMenuEtudiant scannerMenuEtudiant;
    public EtudiantController() {
        displayeEtudiant = new ConsoleDisplayEtudiant();
        DataSource dataSource = new MysqlDataSource();
        EtudiantRepository etudiantRepository = new JdbcEtudiantRepository(dataSource) ;
        scannerMenuEtudiant = new ScannerMenuEtudiant(etudiantRepository,displayeEtudiant);

    }

    public void process(){

        displayeEtudiant.afficherBienvenu();
        displayeEtudiant.afficherMenuPrincipal();
        scannerMenuEtudiant.afficherMenu();
    }
}
