package com.compasso.catalog.product.productms;

import com.compasso.catalog.product.productms.entities.Product;
import com.compasso.catalog.product.productms.repositories.ProductRepository;
import com.compasso.catalog.product.productms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping
    private ResponseEntity<Void> getProducts(){
        productService.insert(new Product("iPhone", "Premium Smartphone", 5000.0));
        return ResponseEntity.noContent().build();
    }

}
