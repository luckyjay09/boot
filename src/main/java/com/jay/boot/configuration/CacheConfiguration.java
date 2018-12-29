package com.jay.boot.configuration;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class CacheConfiguration {

    @Bean
    public CacheManager simpleCacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();

        ConcurrentMapCache concurrentMapCache = new ConcurrentMapCache("cache-1");

        simpleCacheManager.setCaches(Collections.singleton(concurrentMapCache));
        return simpleCacheManager;
    }
}
