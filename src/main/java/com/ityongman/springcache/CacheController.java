package com.ityongman.springcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ityongman.springcache.service.MusicService;

@RestController
@RequestMapping("/cache")
public class CacheController {
	private static Logger log = LoggerFactory.getLogger(CacheController.class);
	
	@Autowired
	private MusicService musicService ;
	
	@RequestMapping("/findAll")
	public String findAll() {
		return String.join(",", musicService.findAll()) ;
	}
	
	@RequestMapping("/findIndex")
	public String findIndex(@RequestParam int index) {
		return musicService.findByIndex(index);
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam String instrument) {
		musicService.save(instrument);
		return "SUCCESS";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam String instrument) {
		musicService.delete(instrument);
		return "SUCCESS";
	}
	
	@RequestMapping("deleteAll") 
	public String deleteAll() {
		musicService.deleteAll(); 
		return "SUCCESS";
	}
	
	@RequestMapping("play")
	public String play(@RequestParam String instrument) {
		musicService.play(instrument);
		return "SUCCESS";
	}
}
