package com.ityongman;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import com.ityongman.spring.generic.GenericSpringEvent;

@SpringBootApplication
public class Application {
	/**
	 * spring boot startting not trigger ContextStartedEvent, but trigger ContextRefreshedEvent
	 * if you want trigger ContextStartedEvent, you can start main function with :
	 * SpringApplication.run(Application.class, args).start()
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
//		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		
//		MyEvenPublisherBean publisherBean = context.getBean(MyEvenPublisherBean.class);
//		publisherBean.sendMsg("A test msg");
//		
//		MyGenericPublishBean genericPublishBean = context.getBean(MyGenericPublishBean.class);
//		GenericSpringEvent<Object> generic = new GenericSpringEvent<Object>("hahaha", true);
//		genericPublishBean.sendMsg(generic);
	}
	
	
//	@Bean  // had creted GenericSpringEvent
	MyGenericListenerBean genericListenerBean() {
		return new MyGenericListenerBean();
	}
	
	@Bean
	MyGenericPublishBean genericPublishBean() {
		return new MyGenericPublishBean() ;
	}
	
//	@Bean
//	MyEvenPublisherBean publisherBean() {
//		return new MyEvenPublisherBean();
//	}
//	
//	@Bean
//	MyListenerBean listenerBean() {
//		return new MyListenerBean() ;
//	}
//	/**
//	 * 测试发布对象
//	 */
//	private static class MyEvenPublisherBean {
//		@Autowired
//		private ApplicationEventPublisher applicationEventPublisher ;
//		
//		public void sendMsg(String msg) {
//			applicationEventPublisher.publishEvent(new MyEvent(msg));
//		}
//	} 
//	
//	/**
//	 * 测试event对象
//	 */
//	private static class MyEvent {
//		private final String msg ;
//
//		public MyEvent(String msg) {
//			this.msg = msg ;
//		}
//
//		public String getMsg() {
//			return msg;
//		}
//		
//	}
//	
//	/**
//	 * 测试  简体Bean对象
//	 */
//	private static class MyListenerBean {
//		@EventListener
//		public void onEvent(MyEvent event) {
//			System.out.println("event received: " + event.getMsg());
//		}
//	}
	
	private static class MyGenericPublishBean {
		@Autowired
		private ApplicationEventPublisher applicationEventPublisher ;
		
		public void sendMsg(GenericSpringEvent<Object> generic) {
			applicationEventPublisher.publishEvent(generic);
		}
	}
	
	/**
	 * 泛型listener对象信息
	 */
	private static class MyGenericListenerBean {
		@EventListener
		public void onEvent(GenericSpringEvent<Object> generic) {
			System.out.println("---->" + generic.getData());
		}
	}
	
}
