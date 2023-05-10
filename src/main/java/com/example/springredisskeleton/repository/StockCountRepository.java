package com.example.springredisskeleton.repository;

import com.example.springredisskeleton.entity.StockCount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockCountRepository extends CrudRepository<StockCount, Long>, StockCountRedisRepository {
}
