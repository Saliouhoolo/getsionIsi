package com.mycompany.app.service;

import com.mycompany.app.domain.Visile;

public interface DisplayeVisile {
    void afficherBienvenu();
    void afficherMenuPrincipal();
    void afficherListeVisiles(Visile [] visiles);
    Visile addVisile();
    void  afficherOptionInconnue();
    Visile updateVisile();
    int deleteVisile();

}
