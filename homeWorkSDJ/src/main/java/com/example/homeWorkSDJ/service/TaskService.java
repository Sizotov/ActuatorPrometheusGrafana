package com.example.homeWorkSDJ.service;

import com.example.homeWorkSDJ.model.Task;
import com.example.homeWorkSDJ.model.TaskStatus;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task getTaskById(Long id);
    Task addTask(Task task);
    List<Task> getTasksByStatus(TaskStatus status);
    Task updateTaskStatus(Long id, Task task);
    void deleteTask(Long id);
}
