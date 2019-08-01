package com.ityongman.spring.synevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ityongman.spring.synevents.publisher.CustomSpringEventPublisher;

@RestController
@RequestMapping("/event")
public class EventController {
	@Autowired
	private CustomSpringEventPublisher customSpringEventPublisher;
	
	/**
	 * 如果想使用同步, 可以将config目录下的配置去掉
	 * @return
	 */
	@RequestMapping("/business")
	@ResponseBody
	public String getBusiness() {
		customSpringEventPublisher.doStuffAndPublishAnEvent("business");
		return "business";
	}
	
	@RequestMapping("/generic")
	@ResponseBody
	public String getGeneric() {
		customSpringEventPublisher.doStuffAndPublishAnEvent("business");
		return "generic";
	}
}
