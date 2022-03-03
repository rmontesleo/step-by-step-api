package com.demo.stepapi.steps.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

import com.demo.stepapi.steps.entities.Job;
import com.demo.stepapi.steps.entities.Task;
import com.demo.stepapi.steps.service.JobService;
import com.demo.stepapi.steps.service.TaskS06Service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/steps/09/jobs/simple")
@RequiredArgsConstructor
public class SimpleJobController {

	
	private final JobService service;
		
	private final Log LOGGER = LogFactory.getLog( SimpleJobController.class );


	@GetMapping("")
	public ResponseEntity<List<Job>> fetchAllTask(){
		return ResponseEntity.ok().body( service.findAllJobs() );
	}
	

	@PostMapping("")
	public ResponseEntity<Job> postTask( @RequestBody Job newJob ){		
		LOGGER.debug("## the new job log.debug is" + newJob );
		return ResponseEntity.status(HttpStatus.CREATED).body( service.saveJob(newJob)  );
	}	

	/*
	
	@GetMapping("/{taskId}")
	public ResponseEntity<Task> getTaskById( @PathVariable("taskId") Long taskId  ){
		LOGGER.debug( "the task id is "+ taskId );

		return service.findTaskById(taskId)
				.map( task -> ResponseEntity.ok().body(task)  )
				.orElse( ResponseEntity.status(HttpStatus.NOT_FOUND).build()  );
	}


	@GetMapping("/owner/{ownerId}")
	public ResponseEntity<List<Task>> fetchTaskByOwner( @PathVariable String ownerId ){
		return  ResponseEntity.ok().body( service.findByOwnerId(ownerId) ) ;
	}


	@GetMapping("/owner/{ownerId}/active")
	public ResponseEntity<List<Task>> fetchTaskByOwnerAndStatus( 
		@PathVariable String ownerId,
		@RequestParam(name="status") boolean active ){
		return  ResponseEntity.ok()
					.body( service.findByOwnerIdAndStatus(ownerId, active)  ) ;
	}

	@GetMapping("/owner/{ownerId}/optional")
	public ResponseEntity<List<Task>> fetchTaskByOwnerOptionalStatus( 
		@PathVariable String ownerId,
		@RequestParam(name="status", defaultValue = "true") boolean active ){
		return  ResponseEntity.ok()
					.body( service.findByOwnerIdAndStatus(ownerId, active)  ) ;
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

	*/
    
}
