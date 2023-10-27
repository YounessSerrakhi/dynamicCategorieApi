package com.example.dynamiccategoryapi.controllers;

import com.example.dynamiccategoryapi.dtos.CaracteristicDTO;
import com.example.dynamiccategoryapi.dtos.TypeRequestDTO;
import com.example.dynamiccategoryapi.entities.Caracteristic;
import com.example.dynamiccategoryapi.entities.Product;
import com.example.dynamiccategoryapi.entities.Type;
import com.example.dynamiccategoryapi.servicesImpl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/types")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping("/getType/{typeId}")
    public Type getType(@PathVariable Integer typeId){
        return typeService.getType(typeId);
    }

    @GetMapping("/getAllTypes")
    public List<Type> getAllTypes(){
        return typeService.getAllTypes();
    }
    @GetMapping("/getTypeWithProduct/{typeId}")
    public List<Product> getTypeWithProduct(@PathVariable Integer typeId){
         return typeService.getTypeWithProducts(typeId);

    }
}
