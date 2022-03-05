package com.demo.stepapi.steps.controller;

import java.util.List;

import com.demo.stepapi.steps.entities.Job;
import com.demo.stepapi.steps.service.JobService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/steps/09/requirement")
public record RecordRequirementController( JobService service ){
		
	private static final Log LOGGER = LogFactory.getLog( RecordRequirementController.class );

	@GetMapping("")
	public ResponseEntity<List<Job>> fetchAllTask(){
		return ResponseEntity.ok().body( service.findAllJobs() );
	}	

	@PostMapping("")
	public ResponseEntity<Job> postTask( @RequestBody Job newJob ){		
		LOGGER.debug("## the new job log.debug is" + newJob );
		return ResponseEntity.status(HttpStatus.CREATED).body( service.saveJob(newJob)  );
	}	

    
}
