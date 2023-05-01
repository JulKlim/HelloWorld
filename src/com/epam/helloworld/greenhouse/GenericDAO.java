package com.epam.helloworld.greenhouse;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T, ID> {
    T create(T entity) throws SQLException;

    List<T> findAll() throws SQLException;

    T update(T entity) throws SQLException;

    void delete(ID id) throws SQLException;
}
