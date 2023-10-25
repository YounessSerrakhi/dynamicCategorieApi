package com.example.dynamiccategoryapi.entities;

import jakarta.persistence.*;
@Entity
public class Caracteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caracteristicId;

    private String caracteristicName;
    private String caracteristicType;

    @ManyToOne
    @JoinColumn(name = "typeId") // "typeId" should match the name of the column in the Type table
    private Type type;

    // Constructors, getters, setters, and other methods
}
