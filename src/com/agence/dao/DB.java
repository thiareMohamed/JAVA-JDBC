package com.agence.dao;

import java.sql.*;

public class DB {
    public Connection cxn;

    public DB(){

    }

    public Connection connexion() throws SQLException {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/agencedb";
            String username = "root";
            String password = "root";
            return this.cxn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
