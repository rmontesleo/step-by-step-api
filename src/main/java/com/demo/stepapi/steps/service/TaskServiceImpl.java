package com.demo.stepapi.steps.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.demo.stepapi.steps.entities.Task;
import com.demo.stepapi.steps.repository.TaskRepository;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("taskService")
public class TaskServiceImpl implements ITaskService {
	
	private final TaskRepository repository;

	private final Log LOGGER = LogFactory.getLog(TaskServiceImpl.class);

	public TaskServiceImpl( TaskRepository repository){
		this.repository = repository;
	}
	
	public List<Task> getAllTask(){
		List<Task> taskList =  repository.findAll();
		LOGGER.debug( "----  All task are " +  printAllTask( taskList ) + "---------" );
		return  taskList;
	}


	
	public Task saveTask( Task newTask ){
		LOGGER.debug("### new task in service " + newTask  );
		newTask.setCreatedAt(LocalDateTime.now() );
		newTask.setActive(true);

		return  repository.save(newTask);
	}

	public Optional<Task> findTaskById( Long taskId  ){
		LOGGER.debug("### FROM Service task id is "+ taskId  );
		

		return  repository.findById( taskId  );
	}

	@Transactional
	public boolean deleteTask( Long taskId ){
		try {
			Long rows = repository.deleteByTaskId(taskId);
			LOGGER.debug( "deleted rows are " + rows  );
			
			return  rows == 1 ? true: false;	
		} catch (Exception e ) {
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
					wanted.setActive( updatedTask.getActive() );
					wanted.setOwnerId( updatedTask.getOwnerId() );
					return repository.save(wanted);
				});

	}

	public List<Task> findByOwnerId(String ownerId){
		return repository.findByOwnerId(ownerId);
	}

	public List<Task> findByOwnerIdAndStatus(String ownerId, boolean status){
		return repository.findByOwnerIdAndActive(ownerId, status);
	}
    
}
