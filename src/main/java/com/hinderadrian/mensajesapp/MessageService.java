package com.hinderadrian.mensajesapp;

import java.util.Scanner;

/**
 *
 * @author hinder
 */
public class MessageService {
    
    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe tu mensaje:");
        String message = sc.nextLine();
        
        System.out.println("Escribe tu nombre::");
        String messageAuthor = sc.nextLine();
        
        Message messageRegister = new Message();
        messageRegister.setMessage(message);
        messageRegister.setMessageAuthor(messageAuthor);
        
        MessageDAO.createMessageDB(messageRegister);
        
    }
    
    public static void listMessages () {
        MessageDAO.readMessageDB();
    }
    
    public static void deleteMesssage () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar:");
        int idMensaje = sc.nextInt();
        MessageDAO.deleteMessageDB(idMensaje);
    }
    
    public static void editMessage () {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe tu nuevo mensaje:");
        String message = sc.nextLine();
        
        System.out.println("Indica el ID del mensaje a editar:");
        int messageId = sc.nextInt();
        
        Message messageToUpdate = new Message();
        messageToUpdate.setMessageId(messageId);
        messageToUpdate.setMessage(message);
        MessageDAO.updateMessage(messageToUpdate);
    }
    
}
