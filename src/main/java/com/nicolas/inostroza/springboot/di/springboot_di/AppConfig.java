package com.nicolas.inostroza.springboot.di.springboot_di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.nicolas.inostroza.springboot.di.springboot_di.repositories.ProductRepository;
import com.nicolas.inostroza.springboot.di.springboot_di.repositories.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Bean
    @Primary
    ProductRepository productRepository() {
        return new ProductRepositoryJson();
    }

}
