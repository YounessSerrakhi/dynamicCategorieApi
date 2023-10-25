package com.example.dynamiccategoryapi.servicesImpl;

import com.example.dynamiccategoryapi.entities.Type;
import com.example.dynamiccategoryapi.repositories.TypeRepository;
import com.example.dynamiccategoryapi.services.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type insertType(Type type) {
        return typeRepository.save(type);
    }
}
