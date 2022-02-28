package com.demo.stepapi.steps.repository;

import com.demo.stepapi.steps.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;




public interface TaskRepository extends JpaRepository<Task, Long>  {
    
}
