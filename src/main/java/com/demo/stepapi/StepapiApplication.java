package com.demo.stepapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StepapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StepapiApplication.class, args);
	}


	@GetMapping("/hello")
	public String greet(){
		return "Hello World of SpringBoot!";
	}

	@GetMapping("/all")
	public String fetchAllTask(){
		return "all task";
	}

	@PostMapping("")
	public String postTask(){
		return "posting task";
	}

	@GetMapping("")
	public String getTaskById(){
		return "by id";
	}


	@DeleteMapping("")
	public String deleteTask(){
		return "delte";
	}

	@PutMapping("")
	public String putTask(){
		return "updating task";
	}




}
