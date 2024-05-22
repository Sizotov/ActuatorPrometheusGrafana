package com.example.homeWorkSDJ.service;

import com.example.homeWorkSDJ.model.Task;
import com.example.homeWorkSDJ.model.TaskStatus;
import com.example.homeWorkSDJ.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Задача не найдена"));
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    @Override
    public Task updateTaskStatus(Long id, Task task) {
        Task existingTask = getTaskById(id);
        existingTask.setStatus(task.getStatus());
        existingTask.setDescription(task.getDescription());
        existingTask.setCreatedDate(task.getCreatedDate());
        return taskRepository.save(existingTask);
    }

    @Override
    public void deleteTask(Long id) {
        getTaskById(id);
        taskRepository.deleteById(id);
    }
}
