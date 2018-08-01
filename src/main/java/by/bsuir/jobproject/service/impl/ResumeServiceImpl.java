package by.bsuir.jobproject.service.impl;


import by.bsuir.jobproject.dao.impl.ResumeDAOImpl;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.exception.ServiceException;
import by.bsuir.jobproject.model.Resume;
import by.bsuir.jobproject.service.Service;

import java.util.ArrayList;


public class ResumeServiceImpl implements Service<Resume> {

    private ResumeDAOImpl resumeDAO = new ResumeDAOImpl();

    @Override
    public ArrayList<Resume> getAllEntities() throws ServiceException {
        try {
            return resumeDAO.getAllEntities();
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void addEntity(Resume entity) throws ServiceException {
        try {
            resumeDAO.addEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean deleteEntity(int entity_id) throws ServiceException {
        try {
            resumeDAO.deleteEntity(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public boolean updateEntity(Resume entity) throws ServiceException {
        try {
            resumeDAO.updateEntity(entity);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
        return false;
    }

    @Override
    public Resume getEntityById(int entity_id) throws ServiceException {
        try {
            return resumeDAO.getEntityById(entity_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    public Integer getResumeIdByJobseekerId(int user_id) throws ServiceException  {
        try {
            return resumeDAO.getResumeIdByJobseekerId(user_id);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}