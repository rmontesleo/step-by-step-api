package com.demo.stepapi.steps.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.demo.stepapi.steps.entities.Task;
import com.demo.stepapi.steps.service.TaskS04Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/steps/04/tasks")
public class TaskS04Controller {

	
	private final TaskS04Service service;

	private final Log LOGGER = LogFactory.getLog(TaskS04Controller.class);
	
	public TaskS04Controller( @Autowired TaskS04Service service ){
		this.service = service;
	}


	@GetMapping("")
	public ResponseEntity<List<Task>> fetchAllTask(){
		return ResponseEntity.ok().body( service.getAllTask() );
	}
	

	@PostMapping("")
	public ResponseEntity<Task> postTask( @RequestBody Task newTask ){
		System.out.println( "------ the new task is " + newTask );

		LOGGER.error("## the new task with log.error is" + newTask );
		LOGGER.warn("## the new task with log.warning  is" + newTask );
		LOGGER.info("## the new task with log.info  is" + newTask );		
		LOGGER.debug("## the new task log.debug is" + newTask );

		return ResponseEntity.status(HttpStatus.CREATED).body( service.saveTask(newTask)  );
	}

	
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById( @PathVariable("taskId") Long taskId  ){
		LOGGER.debug( "the task id is "+ taskId );

		return service.findTaskById(taskId)
				.map( task -> ResponseEntity.ok().body(task)  )
				.orElse( ResponseEntity.status(HttpStatus.NOT_FOUND).build()  );
	}


	

	@DeleteMapping("/{taskId}")
	public ResponseEntity<Void> deleteTask( @PathVariable("taskId") Long taskId ){
		boolean isDelete =  service.deleteTask(taskId);

		LOGGER.debug("deleted result is " + isDelete ) ;

		if( isDelete ){
			return ResponseEntity.status( HttpStatus.NO_CONTENT ).build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build() ;
				
	}

	
	@PutMapping("/{taskId}")
	public ResponseEntity<Task> putTask(  
				@PathVariable("taskId") Long taskId, 
				@RequestBody Task updatedTask ) {

		return service.updateTask(taskId, updatedTask)
				.map( task ->{
					LOGGER.debug("The updated task was "+ task  );
					return  ResponseEntity.ok().body(task);
				})
				.orElse( ResponseEntity.status(HttpStatus.NOT_FOUND).build() );					
	}	
    
}
