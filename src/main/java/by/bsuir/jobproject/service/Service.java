package by.bsuir.jobproject.service;


import by.bsuir.jobproject.exception.ServiceException;

import java.util.ArrayList;


public interface Service<T> {
    ArrayList<T> getAllEntities() throws ServiceException;

    void addEntity(T entity) throws ServiceException;

    boolean deleteEntity(int entity_id) throws ServiceException;

    boolean updateEntity(T entity) throws ServiceException;

    T getEntityById(int entity_id) throws ServiceException;

}
