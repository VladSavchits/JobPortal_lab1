package by.bsuir.jobproject.util;


import by.bsuir.jobproject.exception.DAOException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public abstract class MySQLConnector {

    private static final String PROPERTIES_FILE = "/db.properties";
    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "user";
    private static final String PROPERTY_PASSWORD = "password";

    private Connection connection;

    protected Connection getConnection() {
        if (connection != null)
            return connection;

        InputStream inputStream = MySQLConnector.class.getResourceAsStream(PROPERTIES_FILE);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String url = properties.getProperty(PROPERTY_URL);
            String driver = properties.getProperty(PROPERTY_DRIVER);
            String user = properties.getProperty(PROPERTY_USERNAME);
            String password = properties.getProperty(PROPERTY_PASSWORD);
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new DAOException(e);
        }
        return connection;
    }

    protected void closeConnection() {
        if (connection == null)
            return;
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }


}