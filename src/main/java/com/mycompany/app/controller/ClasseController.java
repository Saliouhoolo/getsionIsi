package com.mycompany.app.controller;

import com.mycompany.app.repository.jdbc.DataSource;
import com.mycompany.app.repository.jdbc.ClasseRepository;
import com.mycompany.app.repository.jdbc.jdbcClasseRepository;
import com.mycompany.app.repository.jdbc.MysqlDataSource;
import com.mycompany.app.service.DisplayeClasse;
import com.mycompany.app.service.DisplayeClasse;
import com.mycompany.app.service.console.ConsoleDisplayClasse;
import com.mycompany.app.service.console.ScannerMenuClasse;

public class ClasseController {
    private final DisplayeClasse displayeClasse;
    private final ScannerMenuClasse scannerMenuClasse;
    public ClasseController() {
        displayeClasse = new ConsoleDisplayClasse();
        DataSource dataSource = new MysqlDataSource();
        ClasseRepository classeRepository = new jdbcClasseRepository(dataSource) ;
        scannerMenuClasse = new ScannerMenuClasse(classeRepository,displayeClasse);

    }

    public void process(){

        displayeClasse.afficherBienvenu();
        displayeClasse.afficherMenuPrincipal();

    }
}
