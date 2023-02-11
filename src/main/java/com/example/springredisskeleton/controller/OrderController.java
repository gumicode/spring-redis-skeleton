package com.example.springredisskeleton.controller;

import com.example.springredisskeleton.entity.Order;
import com.example.springredisskeleton.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @PostMapping("/order")
    public Order postPerson(@RequestBody Order order) {
        log.info("{}", order);
        return orderRepository.save(order);
    }

    @GetMapping("/order")
    public Order getPerson(@RequestParam Long id) {
        log.info("{}", id);
        return orderRepository.findById(id)
                .orElseThrow();
    }
}
