package com.ityongman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	/**
	 * spring boot startting not trigger ContextStartedEvent, but trigger ContextRefreshedEvent
	 * if you want trigger ContextStartedEvent, you can start main function with :
	 * SpringApplication.run(Application.class, args).start()
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
