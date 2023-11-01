package com.example.dynamiccategoryapi.controllers;

import com.example.dynamiccategoryapi.dtos.CaracteristicDTO;
import com.example.dynamiccategoryapi.dtos.ProductRequestDTO;
import com.example.dynamiccategoryapi.entities.Caracteristic;
import com.example.dynamiccategoryapi.entities.Product;
import com.example.dynamiccategoryapi.entities.Type;
import com.example.dynamiccategoryapi.servicesImpl.ProductServiceImpl;
import com.example.dynamiccategoryapi.servicesImpl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    TypeServiceImpl typeService;
    //@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping(value = "/addProduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(@RequestPart("image") MultipartFile image, @RequestPart("product") ProductRequestDTO productRequestDTO) throws IOException {
       // System.out.println("Received 'image' part: " + Base64.getEncoder().encodeToString(image.getBytes()));
        System.out.println("Received 'product' part: " + productRequestDTO);
        Product product = new Product();
        product.setProductName(productRequestDTO.getProductName());
        Type type = typeService.getType(productRequestDTO.getTypeId());
        if (type == null) {
        } else {
            product.setType(type);
        }

        Map<Integer, Object> characteristics = new HashMap<>();
        Map<Integer, Object> characteristicDTOs = productRequestDTO.getCharacteristics();
        if (characteristicDTOs != null) {
            for (Map.Entry<Integer, Object> entry : characteristicDTOs.entrySet()) {
                Integer characteristicId = entry.getKey();
                Object value = entry.getValue();
                characteristics.put(characteristicId, value);
            }
            product.setCaracteristics(characteristics);

        }
        product.setImage(image.getBytes());
        return productService.insertProduct(product);
    }

}

