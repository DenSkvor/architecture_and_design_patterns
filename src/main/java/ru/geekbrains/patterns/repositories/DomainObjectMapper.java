package ru.geekbrains.patterns.repositories;

import ru.geekbrains.patterns.entities.DomainObject;

import java.sql.SQLException;

public interface DomainObjectMapper {

    DomainObject findById(long id) throws SQLException;
    void insert(DomainObject obj) throws SQLException;
    void update(DomainObject obj) throws SQLException;
    void delete(DomainObject obj) throws SQLException;
}
