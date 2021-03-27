package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Classe;


public interface ClasseRepository {
    int add(Classe classe);
    int update(Classe classe);
    int delete(int idC);
    Classe[] getAll();
}
