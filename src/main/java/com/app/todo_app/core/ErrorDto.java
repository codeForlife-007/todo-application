package com.app.todo_app.core;

import com.app.todo_app.exception.TaskException;
import lombok.Data;

@Data
public class ErrorDto {
  private String message;
  private String errorDescription;

  public static ErrorDto from(Exception e) {
    ErrorDto errorDto = new ErrorDto();
    errorDto.setMessage(e.getMessage());
    Throwable throwable = e.getCause();
    if (throwable != null) {
      errorDto.setErrorDescription(throwable.getLocalizedMessage());
    }
    return errorDto;
  }

  public static ErrorDto from(TaskException e) {
    ErrorDto errorDto = new ErrorDto();
    errorDto.setMessage(e.getMessage());
    errorDto.setErrorDescription(e.getErrorDescription());
    return errorDto;
  }
}
