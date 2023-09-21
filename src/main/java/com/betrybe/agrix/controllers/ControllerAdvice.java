package com.betrybe.agrix.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Define ControllerAdvice.
 */
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(CustomError.class)
  public ResponseEntity<String> handleCustomError(CustomError e) {
    return ResponseEntity.status(404).body(e.getMessage());
  }
}
