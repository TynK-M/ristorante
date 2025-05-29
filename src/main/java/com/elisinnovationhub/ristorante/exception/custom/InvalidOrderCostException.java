package com.elisinnovationhub.ristorante.exception.custom;

public class InvalidOrderCostException extends RuntimeException {
    public InvalidOrderCostException() {
        super("The cost of the order is not negative or not valid.");
    }
}
