package com.elisinnovationhub.ristorante.exception.custom;

public class DishIdNotFoundException extends RuntimeException {
    public DishIdNotFoundException() {
        super("One or more dish ids are not found.");
    }
}
