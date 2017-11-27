package com.alicja.demo.repository;

import com.alicja.demo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{
}
