package com.yael.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
	
	private static final String URL = "TU BD";
    private static final String USER = "TU USSER";
    private static final String PASSWORD = "TU PWD";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
