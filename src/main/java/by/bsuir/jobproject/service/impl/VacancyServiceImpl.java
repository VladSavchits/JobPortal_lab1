package by.bsuir.jobproject.service.impl;


import by.bsuir.jobproject.dao.impl.VacancyDAOImpl;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.service.Service;

import java.util.ArrayList;


public class VacancyServiceImpl implements Service<Vacancy> {

    private VacancyDAOImpl vacancyDAO = new VacancyDAOImpl();


    public ArrayList<Vacancy> getAllEntities() throws ServiceException {
        try {
            return vacancyDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Vacancy entity) throws ServiceException {
        try {
            vacancyDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            vacancyDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Vacancy entity) throws ServiceException {
        try {
            vacancyDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Vacancy getEntityById(int entity_id) throws ServiceException {
        try {
            return vacancyDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public ArrayList<Vacancy> getEntitiesByEmployer(int entity_id) throws ServiceException {
        try {
            return vacancyDAO.getEntitiesByEmployer(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }




}