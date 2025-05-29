package com.elisinnovationhub.ristorante.exception.custom;

public class EmptyDishListException extends RuntimeException {
  public EmptyDishListException(String message) {
    super(message);
  }
}
