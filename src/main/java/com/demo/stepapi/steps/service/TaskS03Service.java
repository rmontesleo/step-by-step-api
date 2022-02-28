package com.demo.stepapi.steps.service;

import java.security.DrbgParameters.Reseed;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.stepapi.steps.entities.Task;
import com.demo.stepapi.steps.repository.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskS03Service {
	
	private final TaskRepository repository;

	public TaskS03Service( @Autowired TaskRepository repository){
		this.repository = repository;
	}    
  
	public List<Task> getAllTask(){
		return  repository.findAll();
	}
	
	public Task saveTask( Task newTask ){
		return  repository.save(newTask);
	}

	public Optional<Task> findTaskById( Long taskId  ){
		return  repository.findById( taskId  );
	}

	
	public boolean deleteTask( Long taskId ){
		try {
			repository.deleteById(taskId);
			return findTaskById(taskId).isEmpty();	
		} catch (Exception e ) {
			System.out.println( e );
			return false;
		}
		

	}
	
    
	public Optional<Task> updateTask(  
				Long taskId, 
				Task updatedTask ){

		
		return findTaskById(taskId)
				.map( wanted ->{
					wanted.setTitle( updatedTask.getTitle() );
					wanted.setDescription( updatedTask.getDescription() );
					wanted.setUpdatedAt( LocalDateTime.now() );
					return repository.save(wanted);
				});

	}

	
    
}
