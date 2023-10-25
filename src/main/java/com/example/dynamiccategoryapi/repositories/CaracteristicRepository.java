package com.example.dynamiccategoryapi.repositories;

import com.example.dynamiccategoryapi.entities.Caracteristic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaracteristicRepository extends JpaRepository<Caracteristic,Integer> {
}
