package com.example.springredisskeleton.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RedisHash
@ToString
public class Person {

    @Id
    private Long id;
    private String name;
}
