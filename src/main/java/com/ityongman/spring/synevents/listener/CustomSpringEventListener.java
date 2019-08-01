package com.ityongman.spring.synevents.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.ityongman.spring.synevents.event.CustomSpringEvent;


@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent>{

	@Override
	public void onApplicationEvent(CustomSpringEvent event) {
		System.out.println(Thread.currentThread().getName() + " Received spring custom event - " + event.getMessage());
	}

}
