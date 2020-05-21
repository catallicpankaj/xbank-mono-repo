package com.ms2.ms2Assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.ms2")
public class MS2AssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MS2AssignmentApplication.class, args);
	}

}
