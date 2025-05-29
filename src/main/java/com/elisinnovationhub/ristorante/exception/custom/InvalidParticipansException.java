package com.elisinnovationhub.ristorante.exception.custom;

public class InvalidParticipansException extends RuntimeException {
    public InvalidParticipansException() {
        super("Partecipans must be specified and greater than 0 if the in house delivery is selected.");
    }
}
