package by.bsuir.jobproject.dao.impl;

import by.bsuir.jobproject.dao.CrudDAO;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.model.Jobseeker;
import by.bsuir.jobproject.util.ConfigurationManager;
import by.bsuir.jobproject.util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by AR on 30.04.2017.
 */
public class JobseekerDAOImpl extends MySQLConnector implements CrudDAO<Jobseeker> {

    private final String INSERT_JOBSEEKER = "insert into jobseeker (id_user, jobseeker_lastname, jobseeker_name, jobseeker_status) values (?,?,?,?)";
    private final String DELETE_JOBSEEKER_BY_ID = "delete from jobseeker where id_jobseeker=?";
    private final String UPDATE_JOBSEEKER = "update jobseeker set id_user=?, jobseeker_lastname=?, jobseeker_name=?, jobseeker_status=? where id_jobseeker=?";
    private final String SELECT_ALL_JOBSEEKERS = "select id_jobseeker, id_user, jobseeker_lastname, jobseeker_name, jobseeker_status from jobseeker";
    private final String SELECT_JOBSEEKER_BY_ID = "select id_jobseeker, id_user, jobseeker_lastname, jobseeker_name, jobseeker_status from jobseeker where id_jobseeker=?";
    private final String SELECT_JOBSEEKER_ID_BY_USER_ID = "select id_jobseeker, id_user, jobseeker_lastname, jobseeker_name, jobseeker_status from jobseeker where id_user=?";


    @Override
    public void addEntity(Jobseeker jobseeker) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_JOBSEEKER);
            preparedStatement.setInt(1, jobseeker.getUser_id());
            preparedStatement.setString(2, jobseeker.getJobseeker_lastname());
            preparedStatement.setString(3, jobseeker.getJobseeker_name());
            preparedStatement.setString(4, jobseeker.getJobseeker_status());
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
    public void deleteEntity(int jobseeker_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    getConnection().prepareStatement(DELETE_JOBSEEKER_BY_ID);
            preparedStatement.setInt(1, jobseeker_id);
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
    public void updateEntity(Jobseeker jobseeker) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_JOBSEEKER);

            preparedStatement.setInt(1, jobseeker.getUser_id());
            preparedStatement.setString(2, jobseeker.getJobseeker_lastname());
            preparedStatement.setString(3, jobseeker.getJobseeker_name());
            preparedStatement.setString(4, jobseeker.getJobseeker_status());
            preparedStatement.setInt(5, jobseeker.getJobseeker_id());

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
    public ArrayList<Jobseeker> getAllEntities() throws DAOException {
        ArrayList<Jobseeker> jobseekers = new ArrayList<>();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_JOBSEEKERS);
            while (resultSet.next()) {
                Jobseeker jobseeker = new Jobseeker();
                jobseeker.setJobseeker_id(resultSet.getInt(ConfigurationManager.getProperty("JOBSEEKER_ID")));
                jobseeker.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                jobseeker.setJobseeker_lastname(resultSet.getString(ConfigurationManager.getProperty("JOBSEEKER_LASTNAME")));
                jobseeker.setJobseeker_name(resultSet.getString(ConfigurationManager.getProperty("JOBSEEKER_NAME")));
                jobseeker.setJobseeker_status(resultSet.getString(ConfigurationManager.getProperty("JOBSEEKER_STATUS")));
                jobseekers.add(jobseeker);
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
        return jobseekers;
    }

    @Override
    public Jobseeker getEntityById(int jobseeker_id) throws DAOException {
        Jobseeker jobseeker = new Jobseeker();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_JOBSEEKER_BY_ID);
            preparedStatement.setInt(1, jobseeker_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                jobseeker.setJobseeker_id(resultSet.getInt(ConfigurationManager.getProperty("JOBSEEKER_ID")));
                jobseeker.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                jobseeker.setJobseeker_lastname(resultSet.getString(ConfigurationManager.getProperty("JOBSEEKER_LASTNAME")));
                jobseeker.setJobseeker_name(resultSet.getString(ConfigurationManager.getProperty("JOBSEEKER_NAME")));
                jobseeker.setJobseeker_status(resultSet.getString(ConfigurationManager.getProperty("JOBSEEKER_STATUS")));
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

        return jobseeker;
    }

    public Integer getJobseekerIdByUserId(int user_id) {
        Integer jobseeker_id = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_JOBSEEKER_ID_BY_USER_ID);
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                jobseeker_id = resultSet.getInt(ConfigurationManager.getProperty("JOBSEEKER_ID"));
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

        return jobseeker_id;
    }
}
