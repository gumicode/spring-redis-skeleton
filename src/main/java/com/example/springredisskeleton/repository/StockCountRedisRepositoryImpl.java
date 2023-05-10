package com.example.springredisskeleton.repository;

import com.example.springredisskeleton.entity.StockCount;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StockCountRedisRepositoryImpl extends BaseRedisTemplateRepository implements StockCountRedisRepository {

    public StockCountRedisRepositoryImpl(final RedisTemplate<String, String> redisTemplate) {
        super(StockCount.class, redisTemplate);
    }
    @Override
    public void incrementCount(final Long chainVendorGroupId, final Integer count){
        this.increment(chainVendorGroupId, "count", count);
    }

}
