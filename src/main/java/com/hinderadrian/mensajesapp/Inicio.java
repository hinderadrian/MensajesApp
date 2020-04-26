package com.hinderadrian.mensajesapp;

import java.sql.Connection;

/**
 *
 * @author hinder
 */
public class Inicio {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        try (Connection connection = conexion.getConnection()) {
            System.out.println("Conexión exitosa :)  Nombre Base de datos--> " + connection.getCatalog());
        } catch (Exception e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
    }
}
