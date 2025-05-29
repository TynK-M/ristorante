package com.elisinnovationhub.ristorante.exception.custom;

public class OrderNotFoundException extends RuntimeException {
  public OrderNotFoundException(String message) {
    super(message);
  }
}
