package com.jay.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@EnableCaching
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager simpleCacheManager;

    @GetMapping("/save")
    public Map<String, String> save(@RequestParam String key, @RequestParam String value) {
        Cache cache = simpleCacheManager.getCache("cache-1");
        cache.put(key, value);

        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

//    @GetMapping("/get")
//    public Map<String, Object> get(@RequestParam String key) {
//        Cache cache = simpleCacheManager.getCache("cache-1");
//
//        Map<String, Object> map = new HashMap<>();
//        map.put(key, cache.get(key));
//        return map;
//    }
}
