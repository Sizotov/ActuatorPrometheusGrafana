package com.example.homeWorkSDJ.repository;

import com.example.homeWorkSDJ.model.Task;
import com.example.homeWorkSDJ.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    //получить список задач по их статусу

    List<Task> findByStatus(TaskStatus status);
}
