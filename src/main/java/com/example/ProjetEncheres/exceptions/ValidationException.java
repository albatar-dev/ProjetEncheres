package com.example.ProjetEncheres.exceptions;

public class ValidationException extends Exception{

    public ValidationException(String message) {
        super("Erreur de validation : " + message);
    }

}
