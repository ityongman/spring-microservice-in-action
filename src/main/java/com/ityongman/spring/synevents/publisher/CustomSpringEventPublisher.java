package com.ityongman.spring.synevents.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.ityongman.spring.synevents.event.CustomSpringEvent;

@Component
public class CustomSpringEventPublisher {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void doStuffAndPublishAnEvent(final String message) {
		System.out.println("Publishing custom event. ");
		CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
		applicationEventPublisher.publishEvent(customSpringEvent);
	}
}
