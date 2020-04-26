package com.hinderadrian.mensajesapp;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author hinder
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int option = 0;

        do {
            System.out.println("------------------");
            System.out.println("Aplicación de mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensaje");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. Editar mensaje");
            System.out.println("5. Salir");

            //Leemos la opción del usuario
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    MessageService.createMessage();
                    break;
                case 2:
                    MessageService.listMessages();
                    break;
                case 3:
                    MessageService.deleteMesssage();
                    break;
                case 4:
                    MessageService.editMessage();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("No elegiste una opción correcta.");
                    break;
            }

        } while (option != 5);

    }
}
