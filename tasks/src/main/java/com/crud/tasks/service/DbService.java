package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbService {

    private final TaskRepository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }
    public EntityManager getEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnitName");
        return entityManagerFactory.createEntityManager();
    }
    public Task getTaskById(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            Task task = entityManager.find(Task.class, id);
            return task;
        } finally {
            entityManager.close();
        }
    }
}