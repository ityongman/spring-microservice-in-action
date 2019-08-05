package com.ityongman.springrediscache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 *	可以参照 https://www.concretepage.com/spring-boot/spring-boot-redis-cache 进行后续修改
 */
@Configuration
@EnableCaching
@ComponentScan("com.ityongman.springrediscache")
@PropertySource("classpath:redis.properties")
public class RedisCacheConfig {
	
	@Value("${redis.server}")
	private String redisHost ;
	
	@Value("${redis.port}")
	private int redisPort ;
	
	@Bean
	CacheManager cacheManager() {
		return RedisCacheManager.builder(jedisConnectionFactory()).build();
	}
	
	@Bean
	RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		
		return redisTemplate;
	}
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		
		factory.setHostName(redisHost);
		factory.setPort(redisPort);
		factory.setUsePool(true);
		
		return factory ;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer() ;
	}
}
