package com.example.springredisskeleton.repository;

import com.example.springredisskeleton.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
