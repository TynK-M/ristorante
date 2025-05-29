package com.elisinnovationhub.ristorante.exception.custom;

public class DishIdNotFoundException extends RuntimeException {
  public DishIdNotFoundException(String message) {
    super(message);
  }
}
