package com.example.dynamiccategoryapi.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeId;

    private String typeName;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Caracteristic> caracteristics;

    // Constructors, getters, setters, and other methods
}
