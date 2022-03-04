package com.demo.stepapi.steps.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table( name= "requirements")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class Requirement {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long requirmentId;

    @Column( name = "title")
    private String title;
    
    @Column( name = "description")
    private String description;
    
    @Column( name ="owner_id")
    private String ownerId;    
    
    @Column( name = "is_active")
    private Boolean active;
    
    @Column( name = "created_at")
    private LocalDateTime createdAt;
    
    @Column( name = "updated_at")
    private LocalDateTime updatedAt;    


    
    
    
}
