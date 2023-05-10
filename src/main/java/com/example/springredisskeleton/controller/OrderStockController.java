package com.example.springredisskeleton.controller;

import com.example.springredisskeleton.entity.StockCount;
import com.example.springredisskeleton.repository.StockCountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderStockController {

    private final StockCountRepository stockCountRepository;

    @PostMapping("/order_count")
    public void post(@RequestBody StockCount stockCount) {
        log.info("{}", stockCount);
        stockCountRepository.save(stockCount);
    }

    @PostMapping("/order_count/increment")
    public void increment(@RequestBody StockCount stockCount) {
        log.info("{}", stockCount);
        stockCountRepository.incrementCount(stockCount.getId(), stockCount.getCount());
    }
}
