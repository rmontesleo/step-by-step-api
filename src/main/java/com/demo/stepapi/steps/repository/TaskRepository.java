package com.demo.stepapi.steps.repository;

import java.util.List;

import com.demo.stepapi.steps.entities.Task;

import org.springframework.data.jpa.repository.JpaRepository;




public interface TaskRepository extends JpaRepository<Task, Long>  {

    
    Long deleteByTaskId( Long taskId );

    List<Task> findByOwnerId(String ownerId);

    List<Task> findByOwnerIdAndActive (String ownerId, Boolean active);
    
}
