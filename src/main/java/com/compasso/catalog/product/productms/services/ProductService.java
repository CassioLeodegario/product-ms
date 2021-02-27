package com.compasso.catalog.product.productms.services;

import com.compasso.catalog.product.productms.entities.Product;
import com.compasso.catalog.product.productms.repositories.ProductRepository;
import com.compasso.catalog.product.productms.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    public Product find(UUID id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Object not found! Id: " + id + ", Type: " + Product.class.getName()));
    }


    public Product insert(Product obj) {
        obj.setId(null);
        obj = productRepository.save(obj);
        return obj;
    }


}
