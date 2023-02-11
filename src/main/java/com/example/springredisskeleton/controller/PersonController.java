package com.example.springredisskeleton.controller;

import com.example.springredisskeleton.entity.Person;
import com.example.springredisskeleton.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController {

    private final PersonRepository personRepository;

    @PostMapping("/person")
    public Person postPerson(@RequestBody Person person) {
        log.info("{}", person);
        return personRepository.save(person);
    }

    @GetMapping("/person")
    public Person getPerson(@RequestBody Person person) {
        log.info("{}", person);
        return personRepository.findById(person.getId())
                .orElseThrow();
    }
}
