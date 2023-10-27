package com.example.dynamiccategoryapi.servicesImpl;

import com.example.dynamiccategoryapi.entities.Product;
import com.example.dynamiccategoryapi.entities.Type;
import com.example.dynamiccategoryapi.repositories.TypeRepository;
import com.example.dynamiccategoryapi.services.TypeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type insertType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type getType(Integer typeId) {
        return typeRepository.findById(typeId)
                .orElseThrow(() -> new EntityNotFoundException("Type not found with ID: " + typeId));

    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public List<Product> getTypeWithProducts(Integer typeId) {
        return typeRepository.findTypeWithProducts(typeId);
    }


}
