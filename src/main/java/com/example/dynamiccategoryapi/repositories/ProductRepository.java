package com.example.dynamiccategoryapi.repositories;

import com.example.dynamiccategoryapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <Product,Integer>{
}
