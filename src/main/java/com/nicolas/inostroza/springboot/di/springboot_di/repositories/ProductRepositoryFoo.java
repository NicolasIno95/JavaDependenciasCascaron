package com.nicolas.inostroza.springboot.di.springboot_di.repositories;

import java.util.Collections;
import java.util.List;


import org.springframework.stereotype.Repository;

import com.nicolas.inostroza.springboot.di.springboot_di.models.Product;


@Repository
public class ProductRepositoryFoo implements ProductRepository {


    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L,"Televisor oled",600L));
    }

    @Override
    public Product findById(Long id) {
       return new Product(id,"Televisor Oled", 600L);
    }




}
