package com.demo.stepapi.steps.controller;

import java.util.List;

import com.demo.stepapi.steps.entities.Job;
import com.demo.stepapi.steps.service.JobService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/steps/09/jobs")
public class JobController {

	
	private final JobService service;
		
	private final Log LOGGER = LogFactory.getLog( JobController.class );

	private final String projectName;

	private final String yamlValue;
	

	public JobController( 
		JobService service, 
		@Value("${PROJECT_NAME}")String projectName,
		@Value("${myYamlValue}") String yamlValue  ){
		this.service = service;
		this.projectName = projectName;
		this.yamlValue = yamlValue;
	}


	@GetMapping("")
	public ResponseEntity<List<Job>> fetchAllTask(){
		LOGGER.debug("##From Jobs: The Project is  " +  projectName );
		LOGGER.debug("##From Jobs: The value in yaml is " +  yamlValue );		

		return ResponseEntity.ok().body( service.findAllJobs() );
	}
	

	@PostMapping("")
	public ResponseEntity<Job> postTask( @RequestBody Job newJob ){		
		LOGGER.debug("## the new job log.debug is" + newJob );
		return ResponseEntity.status(HttpStatus.CREATED).body( service.saveJob(newJob)  );
	}	

	
    
}
