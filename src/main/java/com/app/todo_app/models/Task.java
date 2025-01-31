package com.app.todo_app.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name =  "title", nullable = false)
  private String title;

  @Column(name = "is_completed", nullable = false)
  private boolean isCompleted;
}
