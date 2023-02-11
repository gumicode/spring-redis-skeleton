package com.example.springredisskeleton;

import com.example.springredisskeleton.entity.Person;
import com.example.springredisskeleton.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRedisSkeletonApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {

        Person person = Person.builder()
                .id(0L)
                .name("name")
                .build();

        personRepository.save(person);
    }

}
