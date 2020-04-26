package com.hinderadrian.mensajesapp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hinder
 */
public class ConnectionDB {
    
    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app?useTimeZone=true&serverTimeZone=UTC", "root", "");
            
        } catch (Exception e) {
            System.out.println(" Conexión no conseguida. Error: " + e.getMessage());
        }
        return connection;
    }
    
}
