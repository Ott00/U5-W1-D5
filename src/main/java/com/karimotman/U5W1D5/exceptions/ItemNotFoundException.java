package com.karimotman.U5W1D5.exceptions;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(long id) {
        super("Il record con l'id " + id + " non è stato trovato!");
    }

    public ItemNotFoundException() {
        super("Il record non è stato trovato!");
    }
}
