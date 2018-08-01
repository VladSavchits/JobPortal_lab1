package by.bsuir.jobproject.dao;


import by.bsuir.jobproject.exception.DAOException;

import java.util.ArrayList;


public interface CrudDAO<T> {

    void addEntity(T entity) throws DAOException;

    void deleteEntity(int entity_id) throws DAOException;

    void updateEntity(T entity) throws DAOException;

    ArrayList<T> getAllEntities() throws DAOException;

    T getEntityById(int entity_id) throws DAOException;
}
