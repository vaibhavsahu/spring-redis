package com.vaibhav.example.springredis;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface PersonRepository {
    void save(Person user);
    Map<String, Person> findAll();
    Person findById(String id);
    void update(Person user);
    void delete(String id);
}
