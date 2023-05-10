package com.example.springredisskeleton.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.Assert;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public abstract class BaseRedisTemplateRepository {
    private static final String SEPARATOR = ":";
    private final Class<?> targetClass;
    private final RedisTemplate<String, String> redisTemplate;

    public BaseRedisTemplateRepository(final Class<?> targetClass, final StringRedisTemplate redisTemplate) {
        Assert.notNull(targetClass, "Domain class must not be null!");
        Assert.notNull(redisTemplate, "redisTemplate class must not be null!");
        RedisHash annotation = targetClass.getAnnotation(RedisHash.class);
        if (annotation == null) {
            throw new IllegalArgumentException("RedisHash annotation is required.");
        }
        this.targetClass = targetClass;
        this.redisTemplate = redisTemplate;
    }
    protected Object delete(final Object id, final String... hashKeys){
        return redisTemplate.opsForHash().delete(this.getKey(id), (Object) hashKeys);
    }
    protected Object hasKey(final Object id, final String hashKey){
        return redisTemplate.opsForHash().hasKey(this.getKey(id), hashKey);
    }

    protected Object get(final Object id, final String hashKey){
        return redisTemplate.opsForHash().get(this.getKey(id), hashKey);
    }

    protected List<Object> multiGet(final Object id, final Collection<Object> hashKeys){
        return redisTemplate.opsForHash().multiGet(this.getKey(id), hashKeys);
    }

    protected Long increment(final Object id, final String hashKey, long delta){
        return redisTemplate.opsForHash().increment(this.getKey(id), hashKey, delta);
    }

    protected Double increment(final Object id, final String hashKey, double delta){
        return redisTemplate.opsForHash().increment(this.getKey(id), hashKey, delta);
    }

    protected Object randomKey(final Object id){
        return redisTemplate.opsForHash().randomKey(this.getKey(id));
    }

    protected List<Object> randomKeys(final Object id, long count){
        return redisTemplate.opsForHash().randomKeys(this.getKey(id), count);
    }

    protected Set<Object> keys(final Object id){
        return redisTemplate.opsForHash().keys(this.getKey(id));
    }

    protected Long lengthOfValue(final Object id, final String hashKey){
        return redisTemplate.opsForHash().lengthOfValue(this.getKey(id), hashKey);
    }

    protected Long size(final Object id){
        return redisTemplate.opsForHash().size(this.getKey(id));
    }

    protected void putAll(final Object id, final Map<?, ?> m){
        redisTemplate.opsForHash().putAll(this.getKey(id), m);
    }

    protected void put(final Object id, final String hashKey, final Object value){
        redisTemplate.opsForHash().put(this.getKey(id), hashKey, value);
    }

    protected Boolean putIfAbsent(final Object id, final String hashKey, final Object value) {
        return redisTemplate.opsForHash().putIfAbsent(this.getKey(id), hashKey, value);
    }

    protected List<Object> values(final Object id) {
        return redisTemplate.opsForHash().values(this.getKey(id));
    }

    protected Map<Object, Object> entries(final Object id) {
         return redisTemplate.opsForHash().entries(this.getKey(id));
    }

    private String getKey(final Object id) {
        return getRedisHashValue() + SEPARATOR + id;
    }

    private String getRedisHashValue() {
        RedisHash annotation = targetClass.getAnnotation(RedisHash.class);
        return annotation.value();
    }
}
