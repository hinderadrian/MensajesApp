package com.hinderadrian.mensajesapp;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author hinder
 */
public class Conexion {
    
    public Connection getConnection () {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app?useTimeZone=true&serverTimeZone=UTC", "root", "");
            
            if (connection != null) {
                System.out.println("Conexión a base de datos exitosa.");
            }
            
        } catch (Exception e) {
            System.out.println(" Conexión no conseguida. Error: " + e.getMessage());
        }
        return connection;
    }
    
}
