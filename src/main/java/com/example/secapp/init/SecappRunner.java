package com.example.secapp.init;

import com.example.secapp.product.Product;
import com.example.secapp.product.ProductRepository;
import com.github.javafaker.Faker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * SecappRunner
 * initailiza database
 */

 @Component
public class SecappRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(SecappRunner.class);

    @Autowired
    private ProductRepository prodRepo;

    @Override
    public void run(String... args) throws Exception {
        double min = 10d;
        double max = 100d;
        
        for (int i = 0; i < 20; i++) {
            Product p = new Product();
            Faker f = new Faker();
            double price = 0d;

            p.setName(f.commerce().productName());
            price = min + (f.random().nextDouble() * (max - min));
            p.setPrice(price);
            
            prodRepo.save(p);
        }
        
    }

    
    
}