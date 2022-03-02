package com.demo.stepapi.steps.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.stepapi.steps.entities.Task;

import org.springframework.stereotype.Service;

@Service
public class TaskS02Service {

    private final List<Task> taskList = new ArrayList<>();
  
	public List<Task> getAllTask(){
		return  taskList;
	}


	public Task saveTask( Task newTask ){		
		long id = taskList.size() + 1;
		newTask.setTaskId( id );
		newTask.setActive(false);
		newTask.setCreatedAt( LocalDateTime.now() );
		taskList.add( newTask);

		return newTask;
	}


	public Optional<Task> findTaskById( Long taskId  ){
		return taskList
			.stream()
			.filter( current -> taskId == current.getTaskId() )
			.findFirst();
	}
	public boolean deleteTask( Long taskId ){
		return findTaskById( taskId )
            .map( task -> {
                taskList.remove(task);
                return true;
            })
            .orElse(false);
	}

    
	public Optional<Task> updateTask(  
				Long taskId, 
				Task updatedTask ){

        return findTaskById(taskId)
                .map( task ->{
                    task.setTitle( updatedTask.getTitle() );
                    task.setDescription(  updatedTask.getDescription() );
                    task.setUpdatedAt( LocalDateTime.now() );
                    return  task;
                });
	}
    
}
