package com.example.dynamiccategoryapi.servicesImpl;

import com.example.dynamiccategoryapi.entities.Product;
import com.example.dynamiccategoryapi.repositories.ProductRepository;
import com.example.dynamiccategoryapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product insertProduct(Product product) {
        return  productRepository.save(product);
    }
}
