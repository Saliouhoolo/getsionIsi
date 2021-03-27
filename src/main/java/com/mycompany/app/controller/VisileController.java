package com.mycompany.app.controller;

import com.mycompany.app.repository.jdbc.DataSource;
import com.mycompany.app.repository.jdbc.MysqlDataSource;
import com.mycompany.app.repository.jdbc.VisileRepository;
import com.mycompany.app.repository.jdbc.jdbcVisileRepository;
import com.mycompany.app.service.DisplayeVisile;
import com.mycompany.app.service.console.ConsoleDisplayVisile;
import com.mycompany.app.service.console.ScannerMenuVisile;

public class VisileController {
    private final DisplayeVisile displayeVisile;
  private final ScannerMenuVisile ScannerMenuVisile;
     public VisileController(){
         displayeVisile = new ConsoleDisplayVisile();
         DataSource dataSource = new MysqlDataSource();
         VisileRepository  visileRepository = new jdbcVisileRepository(dataSource);
         ScannerMenuVisile= new ScannerMenuVisile(visileRepository,displayeVisile);

     }
    public void process(){
         displayeVisile.afficherBienvenu();
         displayeVisile.afficherMenuPrincipal();
         ScannerMenuVisile.afficherMenu();
    }
}
