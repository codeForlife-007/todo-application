package com.app.todo_app.service;

import com.app.todo_app.dto.TaskDto;
import com.app.todo_app.exception.DataValidationException;
import com.app.todo_app.exception.NotFoundException;
import com.app.todo_app.models.Task;
import com.app.todo_app.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

  private final TaskRepository taskRepository;

  public List<Task> getAllTasks() {
    return taskRepository.findAll();
  }

  public void createTask(String title) {
    Task task = new Task();
    task.setTitle(title);
    taskRepository.save(task);
  }

  public Task createTask(TaskDto taskDto) throws DataValidationException {
    taskDto.validate();
    Task task = taskDto.toEntity();
    task.setCompleted(taskDto.getIsCompleted());
    task.setTitle(taskDto.getTitle());
    return taskRepository.save(task);
  }

  public void deleteTask(Long id) {
    taskRepository.deleteById(id);
  }

  public void toggleTask(Long id) throws NotFoundException {
    Task task = taskRepository.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
    task.setCompleted(!task.isCompleted());
    taskRepository.save(task);
  }
}
