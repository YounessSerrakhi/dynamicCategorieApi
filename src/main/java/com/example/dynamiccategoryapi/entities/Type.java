package com.example.dynamiccategoryapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    private String typeName;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Caracteristic> caracteristics;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<Caracteristic> getCaracteristics() {
        return caracteristics;
    }

    public void setCaracteristics(List<Caracteristic> caracteristics) {
        this.caracteristics = caracteristics;
    }
}
