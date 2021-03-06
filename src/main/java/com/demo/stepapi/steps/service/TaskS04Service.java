package com.demo.stepapi.steps.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.demo.stepapi.steps.entities.Task;
import com.demo.stepapi.steps.repository.TaskRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskS04Service {
	
	private final TaskRepository repository;

	private final Log LOGGER = LogFactory.getLog(TaskS04Service.class);

	public TaskS04Service( @Autowired TaskRepository repository){
		this.repository = repository;
	}    
  
	public List<Task> getAllTask(){
		return  repository.findAll();
	}
	
	public Task saveTask( Task newTask ){
		LOGGER.debug("### new task in service " + newTask  );

		return  repository.save(newTask);
	}

	public Optional<Task> findTaskById( Long taskId  ){
		LOGGER.debug("### FROM Service task id is "+ taskId  );
		

		return  repository.findById( taskId  );
	}

	
	public boolean deleteTask( Long taskId ){
		try {
			repository.deleteById(taskId);
			
			return findTaskById(taskId).isEmpty();	
		} catch (Exception e ) {
			System.out.println( "##### error while try to fin and element" );
			LOGGER.error("---- error inf delete task", e );
			
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
