package com.ityongman.springcache.config;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration is simiar to <cache:annotation-driven />
 */
@Configuration
@EnableCaching
public class CacheConfig {
	
	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager cacheManager = new SimpleCacheManager() ;
		cacheManager.setCaches(Arrays.asList(
				new ConcurrentMapCache("directory"),
				new ConcurrentMapCache("instruments")
				));
		
		return cacheManager;
	}
}
