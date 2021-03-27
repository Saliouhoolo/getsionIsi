package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Etudiant;

public interface EtudiantRepository {
    int add(Etudiant etudiant);
    int update(Etudiant etudiant);
    int delete(int idE);
    Etudiant[] getAll();
}
