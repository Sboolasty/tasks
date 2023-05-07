package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public Optional<Task> getTask(final Long taskId) {
        return repository.findById(taskId);
    }
    public Task saveTask(final Task task) {
        return repository.save(task);
    }
}