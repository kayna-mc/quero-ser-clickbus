package com.clickbus.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PlaceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -4835427730016173515L;

  public PlaceNotFoundException(String message) {
    super(message);
  }
}
