package com.demo.stepapi.steps.service;

import java.util.List;
import java.util.Optional;

import com.demo.stepapi.steps.entities.Task;


public interface ITaskService {	
	
	List<Task> getAllTask();
	
	Task saveTask( Task newTask );

	Optional<Task> findTaskById( Long taskId  );
	
	boolean deleteTask( Long taskId );	
    
	Optional<Task> updateTask( Long taskId, Task updatedTask );

	List<Task> findByOwnerId(String ownerId);

	List<Task> findByOwnerIdAndStatus(String ownerId, boolean status);

	default String printAllTask( List<Task> taskList ){		
		return taskList
			.stream()
			.map( current -> current.toString() )
			.reduce( "",  ( concatenated , current)-> concatenated + current );
	}

    
}
