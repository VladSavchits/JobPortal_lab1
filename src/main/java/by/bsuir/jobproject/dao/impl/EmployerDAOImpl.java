package by.bsuir.jobproject.dao.impl;


import by.bsuir.jobproject.dao.CrudDAO;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.model.Employer;
import by.bsuir.jobproject.util.ConfigurationManager;
import by.bsuir.jobproject.util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class EmployerDAOImpl extends MySQLConnector implements CrudDAO<Employer> {

    private final String INSERT_EMPLOYER = "insert into employer (id_user, employer_name, employer_information) values (?,?,?)";
    private final String DELETE_EMPLOYER_BY_ID = "delete from employer where id_employer=?";
    private final String UPDATE_EMPLOYER = "update employer set id_user=?, employer_name=?, employer_information=? where id_employer=?";
    private final String SELECT_ALL_EMPLOYERS = "select id_employer, id_user, employer_name, employer_information from employer";
    private final String SELECT_EMPLOYER_BY_ID = "select id_employer, id_user, employer_name, employer_information from employer where id_employer=?";
    private final String SELECT_EMPLOYER_ID_BY_USER_ID = "select id_employer, id_user, employer_name, employer_information from employer where id_user=?";

    @Override
    public void addEntity(Employer employer) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_EMPLOYER);
            preparedStatement.setInt(1, employer.getUser_id());
            preparedStatement.setString(2, employer.getEmployer_name());
            preparedStatement.setString(3, employer.getEmployer_information());
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
    public void deleteEntity(int employer_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(DELETE_EMPLOYER_BY_ID);
            preparedStatement.setInt(1, employer_id);
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
    public void updateEntity(Employer employer) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_EMPLOYER);

            preparedStatement.setInt(1, employer.getUser_id());
            preparedStatement.setString(2, employer.getEmployer_name());
            preparedStatement.setString(3, employer.getEmployer_information());
            preparedStatement.setInt(4, employer.getEmployer_id());

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
    public ArrayList<Employer> getAllEntities() throws DAOException {
        ArrayList<Employer> employers = new ArrayList<Employer>();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_EMPLOYERS);
            while (resultSet.next()) {
                Employer employer = new Employer();
                employer.setEmployer_id(resultSet.getInt(ConfigurationManager.getProperty("EMPLOYER_ID")));
                employer.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                employer.setEmployer_name(resultSet.getString(ConfigurationManager.getProperty("EMPLOYER_NAME")));
                employer.setEmployer_information(resultSet.getString(ConfigurationManager.getProperty("EMPLOYER_INFO")));
                employers.add(employer);
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
        return employers;
    }

    @Override
    public Employer getEntityById(int employer_id) throws DAOException {
        Employer employer = new Employer();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_EMPLOYER_BY_ID);
            preparedStatement.setInt(1, employer_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employer.setEmployer_id(resultSet.getInt(ConfigurationManager.getProperty("EMPLOYER_ID")));
                employer.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                employer.setEmployer_name(resultSet.getString(ConfigurationManager.getProperty("EMPLOYER_NAME")));
                employer.setEmployer_information(resultSet.getString(ConfigurationManager.getProperty("EMPLOYER_INFO")));
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

        return employer;
    }

    public Integer getEmployerIdByUserId(int user_id) {
        Integer employer_id = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_EMPLOYER_ID_BY_USER_ID);
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                employer_id = resultSet.getInt(ConfigurationManager.getProperty("EMPLOYER_ID"));
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

        return employer_id;
    }
}