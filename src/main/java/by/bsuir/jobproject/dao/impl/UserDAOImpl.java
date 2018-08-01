package by.bsuir.jobproject.dao.impl;


import by.bsuir.jobproject.dao.UserDAO;
import by.bsuir.jobproject.exception.DAOException;
import by.bsuir.jobproject.model.User;
import by.bsuir.jobproject.util.ConfigurationManager;
import by.bsuir.jobproject.util.MySQLConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class UserDAOImpl extends MySQLConnector implements UserDAO {

    private final String INSERT_USER = "insert into user (user_login, user_password, user_email, user_status) values (?,?,?,?)";
    private final String DELETE_USER_BY_ID = "delete from user where id_user=?";
    private final String UPDATE_USER = "update user set user_login=?, user_password=?, user_email=?, user_status=? where id_user=?";
    private final String SELECT_ALL_USERS = "select id_user, user_login, user_password, user_email, user_status from user";
    private final String SELECT_USER_BY_ID = "select id_user, user_login, user_password, user_email, user_status from user where id_user=?";
    private final String SELECT_USER_ID_BY_LOGIN = "select id_user from user where user_login=?";
    private final String AUTHENTICATION = "select * from user where user_login = ? and user_password =?";

    @Override
    public void addEntity(User user) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(INSERT_USER);
            preparedStatement.setString(1, user.getUser_login());
            preparedStatement.setString(2, user.getUser_password());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_status());
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
    public void deleteEntity(int user_id) throws DAOException {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement =
                    getConnection().prepareStatement(DELETE_USER_BY_ID);
            preparedStatement.setInt(1, user_id);
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
    public void updateEntity(User user) throws DAOException {
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(UPDATE_USER);

            preparedStatement.setString(1, user.getUser_login());
            preparedStatement.setString(2, user.getUser_password());
            preparedStatement.setString(3, user.getUser_email());
            preparedStatement.setString(4, user.getUser_status());
            preparedStatement.setInt(5, user.getUser_id());

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
    public ArrayList<User> getAllEntities() throws DAOException {
        ArrayList<User> users = new ArrayList<User>();

        ResultSet resultSet = null;
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                user.setUser_login(resultSet.getString(ConfigurationManager.getProperty("USER_LOGIN")));
                user.setUser_password(resultSet.getString(ConfigurationManager.getProperty("USER_PASSWORD")));
                user.setUser_email(resultSet.getString(ConfigurationManager.getProperty("USER_EMAIL")));
                user.setUser_status(resultSet.getString(ConfigurationManager.getProperty("USER_STATUS")));
                users.add(user);
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
        return users;
    }

    @Override
    public User getEntityById(int user_id) throws DAOException {
        User user = new User();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, user_id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                user.setUser_login(resultSet.getString(ConfigurationManager.getProperty("USER_LOGIN")));
                user.setUser_password(resultSet.getString(ConfigurationManager.getProperty("USER_PASSWORD")));
                user.setUser_email(resultSet.getString(ConfigurationManager.getProperty("USER_EMAIL")));
                user.setUser_status(resultSet.getString(ConfigurationManager.getProperty("USER_STATUS")));
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

        return user;
    }

    public User findUser(String login, String password) {
        User user = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = getConnection().prepareStatement(AUTHENTICATION);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setUser_id(resultSet.getInt(ConfigurationManager.getProperty("USER_ID")));
                user.setUser_login(resultSet.getString(ConfigurationManager.getProperty("USER_LOGIN")));
                user.setUser_password(resultSet.getString(ConfigurationManager.getProperty("USER_PASSWORD")));
                user.setUser_email(resultSet.getString(ConfigurationManager.getProperty("USER_EMAIL")));
                user.setUser_status(resultSet.getString(ConfigurationManager.getProperty("USER_STATUS")));

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

        return user;
    }

    public Integer getUserIdByLogin(String user_login) {
        Integer userId = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_USER_ID_BY_LOGIN);
            preparedStatement.setString(1, user_login);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt(ConfigurationManager.getProperty("USER_ID"));
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

        return userId;
    }
}

