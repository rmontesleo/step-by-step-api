package com.demo.stepapi.steps.service;

import java.time.LocalDateTime;
import java.util.List;

import com.demo.stepapi.steps.entities.Job;
import com.demo.stepapi.steps.repository.JobRepository;

import org.springframework.stereotype.Service;


@Service
public record RequirementService( JobRepository jobRepository ){

    public List<Job> findAllJobs(){
        return jobRepository.findAll();
    }

    public Job saveJob( Job newJob ){
        newJob.setActive(true);
        newJob.setCreatedAt(LocalDateTime.now() );
        return jobRepository.save(newJob);
    }



    
    
}
