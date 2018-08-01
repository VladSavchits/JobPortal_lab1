package by.bsuir.jobproject.dao.impl;


import by.bsuir.jobproject.dao.CrudDAO;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.model.Vacancy;
import by.bsuir.jobproject.util.ConfigurationManager;
import by.bsuir.jobproject.util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class VacancyDAOImpl extends MySQLConnector implements CrudDAO<Vacancy> {

    private final String INSERT_VACANCY = "insert into vacancy (id_employer, vacancy_name, vacancy_requirements, vacancy_payment) values (?,?,?,?)";
    private final String DELETE_VACANCY_BY_ID = "delete from vacancy where id_vacancy=?";
    private final String UPDATE_VACANCY = "update vacancy set id_employer=?, vacancy_name=?, vacancy_requirements=?, vacancy_payment=? where id_vacancy=?";
    private final String SELECT_ALL_VACANCIES = "select id_vacancy, id_employer, vacancy_name, vacancy_requirements, vacancy_payment from vacancy";
    private final String SELECT_VACANCIES_BY_EMPLOYER = "select id_vacancy, id_employer, vacancy_name, vacancy_requirements, vacancy_payment from vacancy where id_employer=?";
    private final String SELECT_VACANCY_BY_ID = "select id_vacancy, id_employer, vacancy_name, vacancy_requirements, vacancy_payment from vacancy where id_vacancy=?";

    @Override
    public void addEntity(Vacancy vacancy) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_VACANCY);
            preparedStatement.setInt(1, vacancy.getEmployer_id());
            preparedStatement.setString(2, vacancy.getVacancy_name());
            preparedStatement.setString(3, vacancy.getVacancy_requirements());
            preparedStatement.setString(4, vacancy.getVacancy_payment());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
               // closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteEntity(int vacancy_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    getConnection().prepareStatement(DELETE_VACANCY_BY_ID);
            preparedStatement.setInt(1, vacancy_id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
               // closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateEntity(Vacancy vacancy) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_VACANCY);

            preparedStatement.setInt(1, vacancy.getEmployer_id());
            preparedStatement.setString(2, vacancy.getVacancy_name());
            preparedStatement.setString(3, vacancy.getVacancy_requirements());
            preparedStatement.setString(4, vacancy.getVacancy_payment());
            preparedStatement.setInt(5, vacancy.getVacancy_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
               // closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public ArrayList<Vacancy> getAllEntities() throws DAOException {
        ArrayList<Vacancy> vacancies = new ArrayList<>();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_VACANCIES);
            while (resultSet.next()) {
                Vacancy vacancy = new Vacancy();
                vacancy.setVacancy_id(resultSet.getInt(ConfigurationManager.getProperty("VACANCY_ID")));
                vacancy.setEmployer_id(resultSet.getInt(ConfigurationManager.getProperty("EMPLOYER_ID")));
                vacancy.setVacancy_name(resultSet.getString(ConfigurationManager.getProperty("VACANCY_NAME")));
                vacancy.setVacancy_requirements(resultSet.getString(ConfigurationManager.getProperty("VACANCY_REQUIREMENTS")));
                vacancy.setVacancy_payment(resultSet.getString(ConfigurationManager.getProperty("VACANCY_PAYMENT")));
                vacancies.add(vacancy);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (statement != null)
                    statement.close();
               // closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return vacancies;
    }

    @Override
    public Vacancy getEntityById(int vacancy_id) throws DAOException {
        Vacancy vacancy = new Vacancy();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_VACANCY_BY_ID);
            preparedStatement.setInt(1, vacancy_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                vacancy.setVacancy_id(resultSet.getInt(ConfigurationManager.getProperty("VACANCY_ID")));
                vacancy.setEmployer_id(resultSet.getInt(ConfigurationManager.getProperty("EMPLOYER_ID")));
                vacancy.setVacancy_name(resultSet.getString(ConfigurationManager.getProperty("VACANCY_NAME")));
                vacancy.setVacancy_requirements(resultSet.getString(ConfigurationManager.getProperty("VACANCY_REQUIREMENTS")));
                vacancy.setVacancy_payment(resultSet.getString(ConfigurationManager.getProperty("VACANCY_PAYMENT")));
            }

        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
               // closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return vacancy;
    }

    public ArrayList<Vacancy> getEntitiesByEmployer(int entity_id) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();

        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {

            preparedStatement = getConnection().prepareStatement(SELECT_VACANCIES_BY_EMPLOYER);
            preparedStatement.setInt(1, entity_id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vacancy vacancy = new Vacancy();
                vacancy.setVacancy_id(resultSet.getInt(ConfigurationManager.getProperty("VACANCY_ID")));
                vacancy.setEmployer_id(resultSet.getInt(ConfigurationManager.getProperty("EMPLOYER_ID")));
                vacancy.setVacancy_name(resultSet.getString(ConfigurationManager.getProperty("VACANCY_NAME")));
                vacancy.setVacancy_requirements(resultSet.getString(ConfigurationManager.getProperty("VACANCY_REQUIREMENTS")));
                vacancy.setVacancy_payment(resultSet.getString(ConfigurationManager.getProperty("VACANCY_PAYMENT")));
                vacancies.add(vacancy);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                // closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return vacancies;
    }
}
