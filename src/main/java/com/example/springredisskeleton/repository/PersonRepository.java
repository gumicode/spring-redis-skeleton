package com.example.springredisskeleton.repository;

import com.example.springredisskeleton.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
