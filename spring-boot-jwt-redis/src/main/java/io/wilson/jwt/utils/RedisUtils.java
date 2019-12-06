//package io.wilson.jwt.utils;
//
//import org.springframework.data.redis.cache.CacheKeyPrefix;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
///**
// * @author Wilson
// * @date 2019/11/5
// **/
//@Component
//public class RedisUtils {
//    @Resource
//    private RedisTemplate redisTemplate;
//
//    public <T> T get(CacheKeyPrefix cacheKeyPrefix, String key) {
//        redisTemplate.opsForValue().
//        return (T) redisTemplate.opsForValue().get(cacheKeyPrefix.compute(key));
//    }
//
//    public boolean delete(CacheKeyPrefix cacheKeyPrefix, String key) {
//        return redisTemplate.delete(cacheKeyPrefix.compute(key));
//    }
//
//    public boolean delete(String key) {
//        return redisTemplate.delete(key);
//    }
//
//    public RedisUtils set(CacheKeyPrefix cacheKeyPrefix, String key, Object value) {
//        redisTemplate.opsForValue().set(cacheKeyPrefix.key(key), value);
//        return this;
//    }
//
//    public RedisUtils set(String key, Object value) {
//        redisTemplate.opsForValue().set(key, value);
//        return this;
//    }
//
//    /**
//     *
//     * @param key
//     * @param value
//     * @param timeout 超时时间，单位s
//     * @return
//     */
//    public RedisUtils set(String key, Object value,long timeout) {
//        redisTemplate.opsForValue().set(key, value,timeout, TimeUnit.SECONDS);
//        return this;
//    }
//
//}
