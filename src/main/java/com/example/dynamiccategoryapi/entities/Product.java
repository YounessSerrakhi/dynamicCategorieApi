package com.example.dynamiccategoryapi.entities;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "typeId") // "typeId" should match the name of the column in the Type table
    private Type type;

    @ElementCollection
    @CollectionTable(name = " caracteristic", joinColumns = @JoinColumn(name = "productId"))
    @MapKeyJoinColumn(name = "caracteristicId") // "caracteristicId" should match the name of the column in the Caracteristic table
    @Column(name = "value")
    private Map<Caracteristic, Object> caracteristics;

    // Constructors, getters, setters, and other methods
}
