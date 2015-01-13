package com.muciek.systemkurierski.exception;

/**
 * @author mwuzynski
 * @version 1.0
 * @since 27.06.2014
 */
public class EmailAlreadyInUseException extends Exception {

    private static final long serialVersionUID = 1L;

    public EmailAlreadyInUseException() {
        super("User with this email already exists.");
    }

    public EmailAlreadyInUseException(String messsage) {
        super(messsage);
    }
}
