package com.example.secapp.product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepo;

    public List<Product> listAllProducts() {

        List<Product> products = StreamSupport
                                 .stream(productRepo.findAll().spliterator(), false)
                                 .collect(Collectors.toList());
        
        return products;
    }
}