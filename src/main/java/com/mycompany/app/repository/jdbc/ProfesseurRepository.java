package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Professeur;

public interface ProfesseurRepository {

    int add(Professeur professeur);
    int update(Professeur professeur);
    int delete(int idPro);
    Professeur[] getAll();
}
