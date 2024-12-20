package com.example.jpa.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class Member {

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Member() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

}