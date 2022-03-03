package com.demo.stepapi.steps.repository;

import com.demo.stepapi.steps.entities.Job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
    
}
