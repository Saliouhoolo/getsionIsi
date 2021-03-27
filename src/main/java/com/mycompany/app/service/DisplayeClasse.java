package com.mycompany.app.service;

import com.mycompany.app.domain.Classe;

public interface DisplayeClasse {
    void afficherBienvenu();
    void afficherMenuPrincipal();
    void afficherListeClasses(Classe[] classes);
    Classe addClasse();
    void  afficherOptionInconnue();
    Classe updateClasse();
    int deleteClasse();
}
