package com.vaibhav.example.springredis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String id;
    private String name;
    private Long salary;

    @JsonCreator
    public Person(@JsonProperty("id") String id,
                  @JsonProperty("name") String name,
                  @JsonProperty("salary") Long salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}
