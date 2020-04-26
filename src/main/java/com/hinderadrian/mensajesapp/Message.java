package com.hinderadrian.mensajesapp;

/**
 *
 * @author hinder
 */
public class Message {
    
    private int messageId;
    private String message;
    private String messageAuthor;
    private String messageDate;

    public Message() {
    }

    public Message(String message, String messageAuthor, String messageDate) {
        this.message = message;
        this.messageAuthor = messageAuthor;
        this.messageDate = messageDate;
    }
    
    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageAuthor() {
        return messageAuthor;
    }

    public void setMessageAuthor(String messageAuthor) {
        this.messageAuthor = messageAuthor;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }
    
}
