package net.dotevolve.base.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheService {
    @Autowired
    CacheManager cacheManager;

    public Object save(String id, Object obj, String collectionName) {
        String key = String.format("%s@%s", id, collectionName);
        cacheManager.getCache(collectionName).put(key, obj);
        return obj;
    }

    public Object get(String id, String collectionName) {
        String key = String.format("%s@%s", id, collectionName);
        return cacheManager.getCache(collectionName).get(key).get();
    }

    public boolean exists(String id, String collectionName) {
        String key = String.format("%s@%s", id, collectionName);
        return cacheManager.getCache(collectionName).get(key) != null;
    }

    public void clearAll(String collectionName) {
        cacheManager.getCache(collectionName).clear();
    }

}
