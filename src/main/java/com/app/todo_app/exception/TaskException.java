package com.app.todo_app.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force = true)
@EqualsAndHashCode(callSuper = true)
public class TaskException extends Exception {
  private final String errorDescription;

  public TaskException(String message) {
    super(message);
    this.errorDescription = "Something went wrong";
  }

  public TaskException(String message, String errorDescription) {
    super(message);
    this.errorDescription = errorDescription;
  }
}
