package com.nicolas.inostroza.springboot.di.springboot_di.repositories;

import java.util.List;

import com.nicolas.inostroza.springboot.di.springboot_di.models.Product;

public interface ProductRepository {
    List<Product>findAll();
    Product findById(Long id);

}
