package com.example.springredisskeleton.repository;

public interface StockCountRedisRepository {

    void incrementCount(final Long chainVendorGroupId, final Integer count);
}
