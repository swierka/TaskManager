package com.alicja.demo.db;

import com.alicja.demo.model.Task;
import com.alicja.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private final EntityManager centityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(EntityManager entityManager){
        super();
        this.centityManager = entityManager;
    }

    public void initializeHibernateSearch(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("db");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }

    @Transactional
    public List<Task> getAll(){
        List<Task> allTasks = taskRepository.findAll();
        return allTasks;
    }

    @Transactional
    public void updateTask (Long id){
        //to do
    }

    @Transactional
    public void addTask (Task task){
        taskRepository.save(task);
    }

    @Transactional
    public Task findById(Long id){
      Task task = taskRepository.findOne(id);
      return task;
    }
}
