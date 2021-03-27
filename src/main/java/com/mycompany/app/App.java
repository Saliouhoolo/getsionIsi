package com.mycompany.app;


import com.mycompany.app.controller.EtudiantController;
import com.mycompany.app.service.console.ScannerMenuClasse;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        EtudiantController etudiantController= new EtudiantController();
        etudiantController.process();

        }
    }

