package com.app.todo_app.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DataValidationException extends TaskException {

  private final String errorDescription;
  public DataValidationException(String message) {
    super(message);
    this.errorDescription = "something went wrong!";
  }

  public DataValidationException(String message, String errorDescription) {
    super(message);
    this.errorDescription = errorDescription;
  }
}
