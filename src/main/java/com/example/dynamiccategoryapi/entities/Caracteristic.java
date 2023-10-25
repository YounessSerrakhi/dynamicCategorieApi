package com.example.dynamiccategoryapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
public class Caracteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer caracteristicId;

    private String caracteristicName;
    private String caracteristicType;

    @ManyToOne
    @JoinColumn(name = "typeId")
    private Type type;

    public Integer getCaracteristicId() {
        return caracteristicId;
    }

    public void setCaracteristicId(Integer caracteristicId) {
        this.caracteristicId = caracteristicId;
    }

    public String getCaracteristicName() {
        return caracteristicName;
    }

    public void setCaracteristicName(String caracteristicName) {
        this.caracteristicName = caracteristicName;
    }

    public String getCaracteristicType() {
        return caracteristicType;
    }

    public void setCaracteristicType(String caracteristicType) {
        this.caracteristicType = caracteristicType;
    }

    public Type getType() {
        return type;
    }
    @JsonIgnore
    public void setType(Type type) {
        this.type = type;
    }
}

