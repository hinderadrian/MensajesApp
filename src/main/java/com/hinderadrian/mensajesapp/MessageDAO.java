package com.hinderadrian.mensajesapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hinder
 */
public class MessageDAO {

    public static void createMessageDB(Message message) {
        ConnectionDB connectionDB = new ConnectionDB();

        try (Connection connection = connectionDB.getConnection()) {
            PreparedStatement preparedStatement = null;

            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?,?)";

                preparedStatement = connection.prepareStatement(query);

                preparedStatement.setString(1, message.getMessage());
                preparedStatement.setString(2, message.getMessageAuthor());
                preparedStatement.executeUpdate();
                System.out.println("Mensaje creado correctamente.");

            } catch (Exception e) {
                System.out.println("Error al insertar mensaje en base de datos. Error --> " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al conectarse a BD. " + e.getMessage());
        }
    }

    public static void readMessageDB() {

        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = connectionDB.getConnection()) {

            try {
                String query = "SELECT * FROM mensajes";
                preparedStatement = connection.prepareStatement(query);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id_mensaje"));
                    System.out.println("ID: " + resultSet.getString("mensaje"));
                    System.out.println("ID: " + resultSet.getString("autor_mensaje"));
                    System.out.println("ID: " + resultSet.getString("fecha_mensaje"));
                    System.out.println("");
                }

            } catch (Exception e) {
                System.out.println("Error al listar los mensajes de la base de datos. Error --> " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al conectarse a BD. " + e.getMessage());
        }
    }

    public static void deleteMessageDB(int idMessage) {
        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement preparedStatement = null;

        try (Connection connection = connectionDB.getConnection()) {

            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, idMessage);
                int countRowsUpated = preparedStatement.executeUpdate();
                
                if (countRowsUpated != 0) {
                    System.out.println("Se ha borrado con éxito el mensaje.");
                } else {
                    System.out.println("El mensaje con ID: " + idMessage + " no ha sido encontrado. No hubo eliminación de registros.");
                }

            } catch (Exception e) {
                System.out.println("Error al eliminar el mensaje de la base de datos. Error --> " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al conectarse a BD. " + e.getMessage());
        }
    }

    public static void updateMessage(Message message) {
        ConnectionDB connectionDB = new ConnectionDB();
        PreparedStatement preparedStatement = null;

        try (Connection connection = connectionDB.getConnection()) {

            try {
                String query = "UPDATE mensajes SET mensaje=? WHERE id_mensaje=?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(2, message.getMessageId());
                preparedStatement.setString(1, message.getMessage());
                int countRowsUpdated = preparedStatement.executeUpdate();
                
                if (countRowsUpdated != 0) {
                    System.out.println("Se han actualizado " + countRowsUpdated + " fila(s) correctamente.");
                } else {
                    System.out.println("No existen registros con el ID " + message.getMessageId() + " para actualizar.");
                }
                

            } catch (Exception e) {
                System.out.println("Error al actualizar el mensaje de la base de datos. Error --> " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Error al conectarse a BD. " + e.getMessage());
        }
    }

}
