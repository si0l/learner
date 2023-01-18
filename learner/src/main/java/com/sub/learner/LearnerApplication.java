package com.sub.learner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @EnableJpaRepositories("com.sub.learner.*")
// @ComponentScan(basePackages = { "com.sub.learner.*" })
// @EntityScan("com.sub.learner.*")  
// @Configuration
public class LearnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnerApplication.class, args);
	}

}
