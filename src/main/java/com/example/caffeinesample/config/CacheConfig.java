package com.example.caffeinesample.config;

import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Caffeine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCaching
public class CacheConfig {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    public static final String CALCULO1 = "calculo1";
    public static final String CALCULO2 = "calculo2";


    @Bean
	@Primary
	public CacheManager cacheDefault() {
		Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder()
				//.maximumSize(1000)
				.expireAfterAccess(30, TimeUnit.SECONDS);
		
        CaffeineCacheManager  cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(cacheBuilder);
		return cacheManager;
	}

	@Bean
    public CacheManager calculo1CacheManager() {
		Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder()
				//.maximumSize(1000)
				.expireAfterAccess(5, TimeUnit.SECONDS);
		
        CaffeineCacheManager  cacheManager = new CaffeineCacheManager(CALCULO1);
		cacheManager.setCaffeine(cacheBuilder);
		return cacheManager;
    }

	@Bean
    public CacheManager calculo2CacheManager() {
		Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder()
				//.maximumSize(1000)
				.expireAfterAccess(10, TimeUnit.SECONDS);
		
        CaffeineCacheManager  cacheManager = new CaffeineCacheManager(CALCULO2);
		cacheManager.setCaffeine(cacheBuilder);
		return cacheManager;
    }
	

}
