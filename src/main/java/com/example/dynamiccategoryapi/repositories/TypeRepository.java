package com.example.dynamiccategoryapi.repositories;

import com.example.dynamiccategoryapi.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type,Integer> {
}
