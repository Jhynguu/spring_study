package com.example.jpql.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@NamedNativeQuery(
        name = "User.findByNameNative",
        query = "SELECT * FROM user WHERE name = :name",
        resultClass = User.class
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
}
