package com.example.secapp.product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * ProductRepository
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    
}