package com.example.springredisskeleton.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Builder
@Getter
@Setter
@RedisHash(value = "stock_count")
@ToString
public class Stock implements Serializable {

	@Id private String id;
	private Integer count;

}
