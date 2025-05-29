package com.elisinnovationhub.ristorante.exception.custom;

import org.apache.coyote.BadRequestException;

public class TooManyDishesException extends RuntimeException {
    public TooManyDishesException() {
        super("Maximum 10 dishes for order.");
    }
}
