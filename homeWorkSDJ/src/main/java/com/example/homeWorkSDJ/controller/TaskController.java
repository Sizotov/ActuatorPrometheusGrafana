package com.example.homeWorkSDJ.controller;

import com.example.homeWorkSDJ.model.Task;
import com.example.homeWorkSDJ.model.TaskStatus;
import com.example.homeWorkSDJ.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index")
public class TaskController {

    private final TaskServiceImpl service;

    @Autowired
    public TaskController(TaskServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return service.getTaskById(id);
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }
    @GetMapping("/{status}")
    public List<Task> getTasksByStatus(@RequestBody TaskStatus status){
        return service.getTasksByStatus(status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
