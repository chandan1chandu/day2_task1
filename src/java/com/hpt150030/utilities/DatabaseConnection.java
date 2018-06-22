/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hpt150030.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Hardik
 */
public class DatabaseConnection {

    public Connection connect = null;
    private Statement statement = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;
    //String db="book";

    public DatabaseConnection() {
        
    }

    public void openConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager
                .getConnection("jdbc:mysql://localhost:1527/book"
                        + "user=localhost1&password=pass");
    }

    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception exp) {

        }
    }
}
