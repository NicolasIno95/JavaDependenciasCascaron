package com.nicolas.inostroza.springboot.di.springboot_di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nicolas.inostroza.springboot.di.springboot_di.models.Product;

public class ProductRepositoryJson implements ProductRepository {

    private List<Product> list;

    public ProductRepositoryJson() {
        Resource resource= new ClassPathResource("product.json");
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            this.list= Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
        } catch (StreamReadException e) {
            e.printStackTrace();
        } catch (DatabindException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        return this.list;
    }

    @Override
    public Product findById(Long id) {
        return this.list.stream().filter(product-> product.getId().equals(id)).findFirst().orElse(null);
    }

}
