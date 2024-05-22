package com.example.homeWorkSDJ;
import com.example.homeWorkSDJ.model.Task;
import com.example.homeWorkSDJ.model.TaskStatus;
import com.example.homeWorkSDJ.repository.TaskRepository;
import com.example.homeWorkSDJ.service.TaskService;
import com.example.homeWorkSDJ.service.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)

public class TaskServiceUTest {

    @InjectMocks
    private TaskServiceImpl taskServiceImpl;

    @Mock
    private TaskRepository taskRepository;

    @Test
    public void testGetAllTasks() {
        Task task = new Task();

        task.setDescription("Test Description");
        task.setStatus(TaskStatus.IN_PROGRESS);

        //Создаем неизменяемый список из одного объекта task c помощью метода Collections.singletonList()
        List<Task> expectedTasks = Collections.singletonList(task);

        //Метод findAll() возвращает список expectedTasks, содержащий одну task
        given(taskRepository.findAll()).willReturn(expectedTasks);

        //Метод getAllTasks() сервиса taskServiceImpl получает список задач из taskRepository
        List<Task> actualTasks = taskServiceImpl.getAllTasks();

        // Проверяем размер списка
        assertEquals(expectedTasks.size(), actualTasks.size());

        // Дополнительные проверки
        assertEquals(expectedTasks.get(0).getDescription(), actualTasks.get(0).getDescription());
        assertEquals(expectedTasks.get(0).getStatus(), actualTasks.get(0).getStatus());
    }
}