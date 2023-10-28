package com.example.dynamiccategoryapi.services;

import com.example.dynamiccategoryapi.entities.Product;
import com.example.dynamiccategoryapi.entities.Type;

import java.util.List;

public interface TypeService {
    Type insertType(Type type);
    Type getType(Integer typeId);

    List<Type> getAllTypes();

    List<Product> getTypeWithProducts(Integer typeId);
}
