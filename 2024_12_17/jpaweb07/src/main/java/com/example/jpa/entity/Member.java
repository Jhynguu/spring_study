package com.example.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Entity
public class Member {

    @Id
    private int id;
    private String name;
    private int age;

    @QueryP
    public Member(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
