package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    void shouldMapTaskToTaskDto() {
        //Given
        Task task = new Task(1L, "sample title", "sample content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(1L, taskDto.getId());
        assertEquals("sample title", taskDto.getTitle());
        assertEquals("sample content", taskDto.getContent());
    }

    @Test
    void shouldMapTaskDtoToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "sample dto title", "sample dto content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(1L, task.getId());
        assertEquals("sample dto title", task.getTitle());
        assertEquals("sample dto content", task.getContent());
    }

    @Test
    void shouldMapTaskListToTaskListDto() {
        //Given
        Task task = new Task(1L, "sample title", "sample content");
        Task task2 = new Task(1L, "sample title", "sample content");
        List<Task> tasks = List.of(task, task2);

        //When
        List<TaskDto> tasksDto = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(2, tasksDto.size());
    }
}
