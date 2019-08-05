package com.ityongman.springrediscache.ctl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ityongman.springrediscache.service.RedisMusicService;

@RestController
@RequestMapping("/redis/cache")
public class RedisCacheController {
	
	@Autowired
	private RedisMusicService redisMusicService ;
	
	@RequestMapping("play")
	public String play(@RequestParam String instrument) {
		redisMusicService.play(instrument) ;
		return instrument ;
	}
}
