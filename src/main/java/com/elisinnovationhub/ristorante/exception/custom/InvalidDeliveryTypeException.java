package com.elisinnovationhub.ristorante.exception.custom;

public class InvalidDeliveryTypeException extends RuntimeException {
    public InvalidDeliveryTypeException() {
        super("The type of the delivery is wrong or not specified.");
    }
}
