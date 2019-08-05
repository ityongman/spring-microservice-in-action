package com.ityongman.springrediscache.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ityongman.springrediscache.service.RedisMusicService;


@Service
@CacheConfig(cacheNames= {"directory", "instruments"})
public class RedisMusicServiceImpl implements RedisMusicService {
	private static Logger log = LoggerFactory.getLogger(RedisMusicServiceImpl.class);
	
//	private static List<String> instruments = new ArrayList<String>();
//	
//	static {
//		instruments.add("Guitar");
//		instruments.add("Bass");
//		instruments.add("Keyboard");
//	}
//	
//	@Override
//	@Cacheable(unless = "#result.size() > 5")
//	public List<String> findAll() {
//		log.info("Executing: " + this.getClass().getSimpleName() + ".findAll();");
//		return instruments;
//	}
//
//	@Override
//	@Cacheable
//	public String findByIndex(int index) {
//		log.info("Executing: " + this.getClass().getSimpleName() + ".findByIndex("+ index +")");
//		return instruments.get(index);
//	}
//
//	@Override
//	@CachePut
//	public void save(String instrument) {
//		log.info("Executing: " + this.getClass().getSimpleName() + ".save(" + instrument + ")");
//		instruments.add(instrument);
//	}
//
//	@Override
//	@CacheEvict
//	public void delete(String instrument) {
//		log.info("Executing: " + this.getClass().getSimpleName() + ".delete(" +instrument+ ")");
//		instruments.remove(instrument);
//	}
//
//	@Override
//	@CacheEvict(allEntries=true)
//	public void deleteAll() {
//		log.info("Executing: " + this.getClass().getSimpleName() + ".deleteAll()");
//		instruments.removeAll(instruments);
//	}

	@Override
	@Cacheable(condition = "#instrument.equals('trombone')")
	public String play(String instrument) {
		log.info("Executing: " + this.getClass().getSimpleName() + ".play(" +instrument+ ")");
		return "paying " + instrument;
	}

}
