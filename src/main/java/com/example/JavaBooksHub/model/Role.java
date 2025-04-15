package com.example.JavaBooksHub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    // Getters, Setters, Constructor


    public Role() {
    }

    public Role(Long id, ERole name) {
        this.id = id;
        this.name = name;
    }

}

