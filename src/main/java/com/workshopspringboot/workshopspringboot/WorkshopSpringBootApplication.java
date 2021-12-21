package com.workshopspringboot.workshopspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WorkshopSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(WorkshopSpringBootApplication.class, args);
	}
}
