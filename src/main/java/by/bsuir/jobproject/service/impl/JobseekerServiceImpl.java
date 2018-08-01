package by.bsuir.jobproject.service.impl;


import by.bsuir.jobproject.dao.impl.JobseekerDAOImpl;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.service.Service;

import java.util.ArrayList;


public class JobseekerServiceImpl implements Service<Jobseeker> {

    private JobseekerDAOImpl jobseekerDAO = new JobseekerDAOImpl();

    @Override
    public ArrayList<Jobseeker> getAllEntities() throws ServiceException {
        try {
            return jobseekerDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Jobseeker entity) throws ServiceException {
        try {
            jobseekerDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            jobseekerDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Jobseeker entity) throws ServiceException {
        try {
            jobseekerDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Jobseeker getEntityById(int entity_id) throws ServiceException {
        try {
            return jobseekerDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Integer getJobseekerIdByUserId(int user_id) throws ServiceException {
        try {
            return jobseekerDAO.getJobseekerIdByUserId(user_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

}
