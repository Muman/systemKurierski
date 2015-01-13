package com.muciek.systemkurierski.exception;

/**
 * @author mwuzynski
 * @version 1.0
 * @since 27.06.2014
 */
public class UsernameAlreadyInUseException extends Exception {

    private static final long serialVersionUID = 1L;

    public UsernameAlreadyInUseException() {
        super("User with this username already exists.");
    }

    public UsernameAlreadyInUseException(String message) {
        super(message);
    }
}