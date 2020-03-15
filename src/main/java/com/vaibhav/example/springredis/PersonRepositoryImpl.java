package com.vaibhav.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private RedisTemplate<String, Person> redis;
    private HashOperations hash;


    @Autowired
    public PersonRepositoryImpl(RedisTemplate<String, Person> redisTemplate){
        this.redis = redisTemplate;
        this.hash = redisTemplate.opsForHash();
    }


    @Override
    public void save(Person user) {
        hash.put("USER", user.getId(), user);
    }

    @Override
    public Map<String, Person> findAll() {
        return hash.entries("USER");
    }

    @Override
    public Person findById(String id) {
        return (Person)hash.get("USER", id);
    }

    @Override
    public void update(Person user) {
        save(user);
    }

    @Override
    public void delete(String id) {
        hash.delete("USER", id);
    }

}
