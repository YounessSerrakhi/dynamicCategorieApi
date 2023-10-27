package com.example.dynamiccategoryapi.repositories;

import com.example.dynamiccategoryapi.entities.Product;
import com.example.dynamiccategoryapi.entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeRepository extends JpaRepository<Type,Integer> {
    @Query("SELECT p FROM Type t " +
            "LEFT JOIN t.products p " +
            "WHERE t.typeId = :typeId")
    List<Product> findTypeWithProducts(@Param("typeId") Integer typeId);
}
