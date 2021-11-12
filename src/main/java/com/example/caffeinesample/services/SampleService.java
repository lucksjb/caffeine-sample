package com.example.caffeinesample.services;

import java.time.LocalDateTime;

import com.example.caffeinesample.config.CacheConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Cacheable(cacheNames = CacheConfig.CALCULO1, cacheManager="calculo1CacheManager")
    public String calculo1(int a) {
        try {
            Thread.sleep(2000L); // simulate a slow process
        } catch (InterruptedException e) {
        }
        log.info("calculou "+LocalDateTime.now());
        return "Cache expira 5 segundos após o ultimo acesso - "+LocalDateTime.now();
    }

    @Cacheable(cacheNames = CacheConfig.CALCULO2, cacheManager="calculo2CacheManager")
    public String calculo2(int a) {
        try {
            Thread.sleep(2000L); // simulate a slow process
        } catch (InterruptedException e) {
        }
        log.info("calculou "+LocalDateTime.now());
        return "Cache expira 10 segundos após o ultimo acesso - "+LocalDateTime.now();
    }

}
