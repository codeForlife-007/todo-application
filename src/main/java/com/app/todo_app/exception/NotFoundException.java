package com.app.todo_app.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NotFoundException extends TaskException {

  private final String errorDescription;

  public NotFoundException(String message) {
    super(message);
    errorDescription = "something went wrong";
  }

  public NotFoundException(String message, String errorDescription) {
    super(message);
    this.errorDescription = errorDescription;
  }
}
