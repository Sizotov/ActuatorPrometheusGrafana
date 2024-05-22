package com.example.homeWorkSDJ;

import com.example.homeWorkSDJ.model.Task;
import com.example.homeWorkSDJ.model.TaskStatus;
import com.example.homeWorkSDJ.repository.TaskRepository;
import com.example.homeWorkSDJ.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest

public class TaskServiceIntegrationTest {

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @MockBean
    private TaskRepository taskRepository;

    @Test
    public void getAllTasksIntegrationTest() {
        Task task = new Task();
        task.setDescription("Integration Test Description");
        task.setStatus(TaskStatus.IN_PROGRESS);

        //Метод findAll() возвращает список Collections.singletonList, содержащий одну task
        when(taskRepository.findAll()).thenReturn(Collections.singletonList(task));

        //Метод getAllTasks() сервиса taskServiceImpl получает список задач из taskRepository
        List<Task> tasks = taskServiceImpl.getAllTasks();

        // Дополнительные проверки
        assertFalse(tasks.isEmpty());
        assertEquals(task.getDescription(), tasks.get(0).getDescription());
        assertEquals(TaskStatus.IN_PROGRESS, tasks.get(0).getStatus());
    }
}

