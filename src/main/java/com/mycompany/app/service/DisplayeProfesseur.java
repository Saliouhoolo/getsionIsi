package com.mycompany.app.service;



import com.mycompany.app.domain.Classe;
import com.mycompany.app.domain.Professeur;

public interface DisplayeProfesseur {
    void afficherBienvenu();
    void afficherMenuPrincipal();
    void afficherListeProfessuers(Professeur[] professeurs);
    Professeur addProfesseur();
    void  afficherOptionInconnue();
    Professeur updateProfesseur();
    int deleteProfesseur();


}
