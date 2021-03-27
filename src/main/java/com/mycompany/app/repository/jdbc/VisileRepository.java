package com.mycompany.app.repository.jdbc;

import com.mycompany.app.domain.Visile;

public interface VisileRepository {
    int add(Visile visile);

    int update(Visile visile);

    int delete(int idV);

    Visile[] getAll();
}
