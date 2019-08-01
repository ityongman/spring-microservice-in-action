package com.ityongman.spring.generic;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * can't implements ApplicationListener, it's need ApplicationEvent,
 * to resolve this problem , you must use annotaion-driver method
 */
@Component
public class GenericSpringEventListener {
	
	@EventListener(condition="#event.success")
	public void handleSuccessful(GenericSpringEvent<String> event) {
		System.out.println("Received spring generic event - " + event.getData());
	}

}
