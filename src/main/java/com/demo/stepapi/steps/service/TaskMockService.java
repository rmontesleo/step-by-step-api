package com.demo.stepapi.steps.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.demo.stepapi.steps.entities.Task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("mockService")
public class TaskMockService implements ITaskService {

    private final List<Task> taskList = new ArrayList<>();

	private final Log LOGGER = LogFactory.getLog(TaskMockService.class);
  
	public List<Task> getAllTask(){
		LOGGER.debug("## from mock the items are " +  printAllTask(taskList) );
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


	@Override
	public List<Task> findByOwnerId(String ownerId) {		
		return null;
	}


	@Override
	public List<Task> findByOwnerIdAndStatus(String ownerId, boolean status) {
		// TODO Auto-generated method stub
		return null;
	}
    
}
