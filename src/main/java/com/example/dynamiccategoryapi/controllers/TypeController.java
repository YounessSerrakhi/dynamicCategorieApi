package com.example.dynamiccategoryapi.controllers;

import com.example.dynamiccategoryapi.dtos.CaracteristicDTO;
import com.example.dynamiccategoryapi.dtos.TypeRequestDTO;
import com.example.dynamiccategoryapi.entities.Caracteristic;
import com.example.dynamiccategoryapi.entities.Type;
import com.example.dynamiccategoryapi.servicesImpl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/types")
public class TypeController {

    @Autowired
    TypeServiceImpl typeService;
    @PostMapping("/addType")
    public Type addType(@RequestBody TypeRequestDTO typeRequestDTO) {
        Type type = new Type();
        type.setTypeName(typeRequestDTO.getTypeName());
        List<CaracteristicDTO> characteristics = typeRequestDTO.getCharacteristics();
        if (characteristics != null) {
            List<Caracteristic> savedCharacteristics = new ArrayList<>();
            for (CaracteristicDTO caracteristicDTO : characteristics) {
                Caracteristic caracteristic = new Caracteristic();
                caracteristic.setCaracteristicName(caracteristicDTO.getCaracteristicName());
                caracteristic.setCaracteristicType(caracteristicDTO.getCaracteristicType());
                caracteristic.setType(type);
                savedCharacteristics.add(caracteristic);
            }

            type.setCaracteristics(savedCharacteristics);
        }
        return typeService.insertType(type);
    }
}
