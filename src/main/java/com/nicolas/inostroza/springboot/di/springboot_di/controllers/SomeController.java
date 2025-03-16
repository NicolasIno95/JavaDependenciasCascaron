package com.nicolas.inostroza.springboot.di.springboot_di.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.inostroza.springboot.di.springboot_di.models.Product;
import com.nicolas.inostroza.springboot.di.springboot_di.services.ProductService;


@RestController
@RequestMapping("/api")
public class SomeController {

    @Autowired
    private ProductService service;

    @GetMapping
    public List<Product> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    public Product show(@PathVariable Long id) {
        return this.service.findById(id);
    }

}
