package by.bsuir.jobproject.service.impl;


import by.bsuir.jobproject.dao.impl.EmployerDAOImpl;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.service.Service;

import java.util.ArrayList;


public class EmployerServiceImpl implements Service<Employer> {

    private EmployerDAOImpl employerDAO = new EmployerDAOImpl();

    @Override
    public ArrayList<Employer> getAllEntities() throws ServiceException {
        try {
            return employerDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Employer entity) throws ServiceException {
        try {
            employerDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            employerDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Employer entity) throws ServiceException {
        try {
            employerDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Employer getEntityById(int entity_id) throws ServiceException {
        try {
            return employerDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Integer getEmployerIdByUserId(int user_id) throws ServiceException {
        try {
            return employerDAO.getEmployerIdByUserId(user_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
