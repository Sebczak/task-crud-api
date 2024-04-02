package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    private final TaskRepository taskRepository;

    @Autowired
    public DbService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);

        if (task.isPresent()) {
            return task.get();
        } else {
            throw new IllegalStateException(String.format("Task with id: %s does not exist", taskId));
        }
    }
}
