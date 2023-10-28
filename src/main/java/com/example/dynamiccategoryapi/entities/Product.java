package com.example.dynamiccategoryapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Map;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    @ElementCollection
    @CollectionTable(name = "product_caracteristic", joinColumns = @JoinColumn(name = "productId"))
    @MapKeyJoinColumn(name = "caracteristicId")
    @Column(name = "value", columnDefinition = "JSON")
    private Map<Integer, Object> caracteristics;

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
    @JsonIgnore
    public void setType(Type type) {
        this.type = type;
    }

    public Map<Integer, Object> getCaracteristics() {
        return caracteristics;
    }

    public void setCaracteristics(Map<Integer, Object> caracteristics) {
        this.caracteristics = caracteristics;
    }
}

