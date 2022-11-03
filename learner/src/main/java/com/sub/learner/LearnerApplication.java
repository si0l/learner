package com.sub.learner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@EnableAutoConfiguration
@SpringBootApplication
public class LearnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnerApplication.class, args);
	}

}
