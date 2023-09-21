package com.betrybe.agrix.controllers;

/**
 * Define CustomError.
 */
public class CustomError extends RuntimeException {

  public CustomError(String message) {
    super(message);
  }
}
