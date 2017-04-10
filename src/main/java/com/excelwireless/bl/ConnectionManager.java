package com.excelwireless.bl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by apatel2 on 4/7/17.
 */
@Component
public class ConnectionManager {

    @Autowired
    private Environment environment;

    @Autowired
    static ConnectionManager connectionManager;


    public Connection getConnection(String driver, String url, String username, String password) throws SQLException {

        Connection connection = null;

        try {
            if (url != null && !url.contains("//")) {
                url = environment.getProperty(url);
            }
            Class.forName(environment.getProperty(driver));
            connection = DriverManager.getConnection(url, environment.getProperty(username),environment.getProperty(password));


        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver Not Found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("DB Connection Failed for URL:::::" + url);
            //e.printStackTrace();
            throw e;
        }

        return connection;

    }
}