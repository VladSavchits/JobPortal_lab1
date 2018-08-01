package by.bsuir.jobproject.dao.impl;


import by.bsuir.jobproject.dao.CrudDAO;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.model.Resume;
import by.bsuir.jobproject.util.ConfigurationManager;
import by.bsuir.jobproject.util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ResumeDAOImpl extends MySQLConnector implements CrudDAO<Resume> {

    private final String INSERT_RESUME = "insert into resume (id_jobseeker, id_specialty, id_skill, resume_information) values (?,?,?,?)";
    private final String DELETE_RESUME_BY_ID = "delete from resume where id_resume=?";
    private final String UPDATE_RESUME = "update resume set id_jobseeker=?, id_specialty=?, id_skill=?, resume_information=? where id_resume=?";
    private final String SELECT_ALL_RESUMES = "select id_resume, id_jobseeker, id_specialty, id_skill, resume_information from resume";
    private final String SELECT_RESUME_BY_ID = "select id_resume, id_jobseeker, id_specialty, id_skill, resume_information from resume where id_resume=?";
    private final String SELECT_RESUME_ID_BY_JOBSEEKER_ID = "select id_resume, id_jobseeker, id_specialty, id_skill, resume_information from resume where id_jobseeker=?";

    @Override
    public void addEntity(Resume resume) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_RESUME);
            preparedStatement.setInt(1, resume.getJobseeker_id());
            preparedStatement.setInt(2, resume.getSpecialty_id());
            preparedStatement.setInt(3, resume.getSkill_id());
            preparedStatement.setString(4, resume.getResume_information());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                //  closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEntity(int resume_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    getConnection().prepareStatement(DELETE_RESUME_BY_ID);
            preparedStatement.setInt(1, resume_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                //  closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateEntity(Resume resume) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_RESUME);

            preparedStatement.setInt(1, resume.getJobseeker_id());
            preparedStatement.setInt(2, resume.getSpecialty_id());
            preparedStatement.setInt(3, resume.getSkill_id());
            preparedStatement.setString(4, resume.getResume_information());
            preparedStatement.setInt(5, resume.getResume_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                //  closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Resume> getAllEntities() throws DAOException {
        ArrayList<Resume> resumes = new ArrayList<Resume>();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_RESUMES);
            while (resultSet.next()) {
                Resume resume = new Resume();
                resume.setResume_id(resultSet.getInt(ConfigurationManager.getProperty("RESUME_ID")));
                resume.setJobseeker_id(resultSet.getInt(ConfigurationManager.getProperty("JOBSEEKER_ID")));
                resume.setSpecialty_id(resultSet.getInt(ConfigurationManager.getProperty("SPECIALITY_ID")));
                resume.setSkill_id(resultSet.getInt(ConfigurationManager.getProperty("SKILL_ID")));
                resume.setResume_information(resultSet.getString(ConfigurationManager.getProperty("RESUME_INFO")));
                resumes.add(resume);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
                //  closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return resumes;
    }

    @Override
    public Resume getEntityById(int id_resume) throws DAOException {
        Resume resume = new Resume();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_RESUME_BY_ID);
            preparedStatement.setInt(1, id_resume);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resume.setResume_id(resultSet.getInt(ConfigurationManager.getProperty("RESUME_ID")));
                resume.setJobseeker_id(resultSet.getInt(ConfigurationManager.getProperty("JOBSEEKER_ID")));
                resume.setSpecialty_id(resultSet.getInt(ConfigurationManager.getProperty("SPECIALITY_ID")));
                resume.setSkill_id(resultSet.getInt(ConfigurationManager.getProperty("SKILL_ID")));
                resume.setResume_information(resultSet.getString(ConfigurationManager.getProperty("RESUME_INFO")));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                //  closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resume;
    }

    public Integer getResumeIdByJobseekerId(int user_id) {
        Integer resume_id = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_RESUME_ID_BY_JOBSEEKER_ID);
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                resume_id = resultSet.getInt(ConfigurationManager.getProperty("RESUME_ID"));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                //  closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return resume_id;
    }
}
