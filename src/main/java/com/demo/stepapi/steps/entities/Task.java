package com.demo.stepapi.steps.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table( name= "tasks")
public class Task {

    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long taskId;

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

    
    @Override
    public String toString() {
        return "Task [active=" + active + ", createdAt=" + createdAt + ", description=" + description + ", taskId="
                + taskId + ", title=" + title + "]";
    }
    
    public Long getTaskId() {
        return taskId;
    }
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }    


    
    
    
}
