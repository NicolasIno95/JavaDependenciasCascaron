package com.nicolas.inostroza.springboot.di.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nicolas.inostroza.springboot.di.springboot_di.models.Product;
import com.nicolas.inostroza.springboot.di.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    // @Qualifier("productList")
    private ProductRepository repository;
    @Autowired
    private Environment environment;
    
    // public ProductServiceImpl(@Qualifier("productList") ProductRepository repository) {
    public ProductServiceImpl( ProductRepository repository) {
        this.repository = repository;
    }

    public List <Product> findAll() {
        return repository.findAll().stream().map(producto-> {
            Double priceImp= producto.getPrice() * this.environment.getProperty("config.price.tax", Double.class);
            // Product newProduct = new Product(producto.getId(), producto.getName(), priceImp.longValue());
            Product newProduct=(Product)producto.clone();
            newProduct.setPrice(priceImp.longValue()); 
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }


}
