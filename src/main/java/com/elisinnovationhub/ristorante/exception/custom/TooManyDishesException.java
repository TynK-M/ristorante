package com.elisinnovationhub.ristorante.exception.custom;

public class TooManyDishesException extends RuntimeException {
  public TooManyDishesException(String message) {
    super(message);
  }
}
