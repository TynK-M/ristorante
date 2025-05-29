package com.elisinnovationhub.ristorante.exception.custom;

import org.apache.coyote.BadRequestException;

public class EmptyDishListException extends RuntimeException {
    public EmptyDishListException() {
        super("Dish list cannot be empty.");
    }
}
