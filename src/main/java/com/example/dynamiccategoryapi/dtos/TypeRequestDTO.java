package com.example.dynamiccategoryapi.dtos;

import java.util.List;

public class TypeRequestDTO {
    private String typeName;
    private List<CaracteristicDTO> characteristics;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<CaracteristicDTO> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<CaracteristicDTO> characteristics) {
        this.characteristics = characteristics;
    }
}
