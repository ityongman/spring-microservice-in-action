package com.ityongman.spring.driver_annotation;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationDrivenContextStartedListener {
	/**
	 * spring boot startting not trigger ContextStartedEvent, but trigger ContextRefreshedEvent
	 * if you want trigger ContextStartedEvent, you can start main function with :
	 * SpringApplication.run(Application.class, args).start()
	 */
//	@Async
	@EventListener
	public void handleContextStart(ContextStartedEvent cse) {
		System.out.println(Thread.currentThread() + " Handling context started event.");
	}
}
