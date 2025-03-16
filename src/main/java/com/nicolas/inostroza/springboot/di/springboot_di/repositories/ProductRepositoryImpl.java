package com.nicolas.inostroza.springboot.di.springboot_di.repositories;


import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nicolas.inostroza.springboot.di.springboot_di.models.Product;

@Repository("productList")
public class ProductRepositoryImpl implements ProductRepository {

    private List<Product> data; 

    public ProductRepositoryImpl() {
        this.data= Arrays.asList(
            new Product(1L,"Memoria Kington 32",300L),
            new Product(2L,"Cpu Inter core i9",300L),
            new Product(3L,"TECLADO RAZER MINI",180L),
            new Product(4L,"Motherboard Gigabyte",490L)
        );
    }

    @Override
    public List <Product> findAll() {
        return this.data;
    }
    
    @Override
    public Product findById(Long id) {
        return data.stream().filter(producto-> producto.getId().equals(id)).findFirst().orElse(null);
    }

}
