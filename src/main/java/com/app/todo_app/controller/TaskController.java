package com.app.todo_app.controller;

import com.app.todo_app.dto.TaskDto;
import com.app.todo_app.exception.DataValidationException;
import com.app.todo_app.exception.NotFoundException;
import com.app.todo_app.models.Task;
import com.app.todo_app.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

  private static final String REDIRECT_URL = "redirect:/tasks";
  private final TaskService taskService;

  @GetMapping
  public String getTasks(Model model) {
    List<Task> tasks = taskService.getAllTasks();
    model.addAttribute("tasks", tasks);
    return "tasks";
  }

  // for thymeleaf
  @PostMapping("/")
  public String createTask(@RequestParam String title) {
    taskService.createTask(title);
    return REDIRECT_URL;
  }

  // for rest API
  @PostMapping
  public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto) throws DataValidationException {
    return ResponseEntity.ok(taskService.createTask(taskDto));
  }

  @GetMapping("/{id}/delete")
  public String deleteTask(@PathVariable Long id) {
    taskService.deleteTask(id);
    return REDIRECT_URL;
  }

  @GetMapping("/{id}/toggle")
  public String toggleTask(@PathVariable Long id) throws NotFoundException {
    taskService.toggleTask(id);
    return REDIRECT_URL;
  }
}
