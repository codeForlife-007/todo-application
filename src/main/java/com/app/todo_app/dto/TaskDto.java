package com.app.todo_app.dto;

import com.app.todo_app.exception.DataValidationException;
import com.app.todo_app.models.Task;
import com.app.todo_app.utils.Missing;
import lombok.Data;

@Data
public class TaskDto {

  private Boolean isCompleted;
  private String title;

  public void validate() throws DataValidationException {
    if (Missing.string(title)) {
      throw new DataValidationException("missing title", "check the required title field");
    }
  }

  // method to convert dto to entity
  public Task toEntity() {
    Task task = new Task();
    task.setCompleted(getIsCompleted());
    task.setTitle(getTitle());
    return task;
  }
}
