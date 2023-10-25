package com.example.dynamiccategoryapi.entities;

import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "typeId") // "typeId" should match the name of the column in the Type table
    private Type type;

    @ElementCollection
    @CollectionTable(name = "product_caracteristic", joinColumns = @JoinColumn(name = "productId"))
    @MapKeyJoinColumn(name = "caracteristicId")
    @Column(name = "value", columnDefinition = "JSON")
    private Map<Caracteristic, Object> caracteristics;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Map<Caracteristic, Object> getCaracteristics() {
        return caracteristics;
    }

    public void setCaracteristics(Map<Caracteristic, Object> caracteristics) {
        this.caracteristics = caracteristics;
    }
}

