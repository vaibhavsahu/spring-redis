package com.vaibhav.example.springredis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/add/{id}/{name}")
    public Person add(@PathVariable("id") final String id,
                    @PathVariable("name") final String name) {
        personRepository.save(new Person(id, name, 20000L));
        return personRepository.findById(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Person update(@PathVariable("id") final String id,
                       @PathVariable("name") final String name) {
        personRepository.update(new Person(id, name, 1000L));
        return personRepository.findById(id);
    }

    @GetMapping("/delete/{id}")
    public Map<String, Person> delete(@PathVariable("id") final String id) {
        personRepository.delete(id);
        return all();
    }

    @GetMapping("/all")
    public Map<String, Person> all() {
        return personRepository.findAll();
    }
}
