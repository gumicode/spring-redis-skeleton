package com.example.springredisskeleton.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.Collection;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "order")
@ToString
public class Order implements Serializable {

    @Id
    private Long id;
    private String user;
    private String vendor;
    private Collection<ProductItems> items;

    @Getter
    @Builder
    public static class ProductItems implements Serializable {
        private Long id;
        private String name;
        private String quantity;
    }
}
